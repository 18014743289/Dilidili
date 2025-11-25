package com.he.dilidili.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.he.dilidili.common.cache.RedisCache;
import com.he.dilidili.common.cache.RedisKeys;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.cache.TokenStoreCache;
import com.he.dilidili.common.constant.Constant;
import com.he.dilidili.common.exception.ErrorCode;
import com.he.dilidili.common.exception.ServerException;
import com.he.dilidili.convert.PersonalInformationConvert;
import com.he.dilidili.mapper.PersonalInformationMapper;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.service.AuthService;
import com.he.dilidili.utils.AIAssistantUtils;
import com.he.dilidili.utils.JwtUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Slf4j
@Service
@AllArgsConstructor
public class AuthServiceImpl extends ServiceImpl<PersonalInformationMapper, PersonalInformation> implements AuthService {
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;


    @Override
    public PersonalInformationVO loginByCode(String phone, String code) {
        boolean isNew = false;
        // 获取验证码cacheKey
        String smsCacheKey = RedisKeys.getSmsKey(phone);
        // 从redis中获取验证码
        Integer redisCode = (Integer) redisCache.get(smsCacheKey);
        // 校验验证码合法性
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.toString().equals
                (code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        // 删除⽤过的验证码
        redisCache.delete(smsCacheKey);
        // 根据⼿机号获取⽤户
        PersonalInformation user = baseMapper.getByPhone(phone);
        // 判断⽤户是否注册过，如果user为空代表未注册，进⾏注册。否则开启登录流程
        if (ObjectUtils.isEmpty(user)) {
            isNew = true;
            log.info("⽤户不存在，创建⽤户, phone: {}", phone);
            user = new PersonalInformation();
//            调用千问大模型，生成随机用户名
            user.setNickName(AIAssistantUtils.createName());
            user.setPhone(phone);
            // 获取当前时间
            LocalDateTime now = LocalDateTime.now();
            user.setCreateTime(now);
            user.setLastLogin(now);
            baseMapper.insert(user);
            user=baseMapper.getByPhone(phone);
        }
        PersonalInformationVO res = getUserLoginVO(user);
        res.setIsNew(isNew);
        return res;
    }

    private PersonalInformationVO getUserLoginVO(PersonalInformation user) {
        // 构造token
        String accessToken = JwtUtil.createToken(user.getId());
        // 构造登陆返回vo
        PersonalInformationVO personalInformationVO = PersonalInformationConvert.INSTANCE.convert(user);
        personalInformationVO.setAccessToken(accessToken);
        tokenStoreCache.saveUser(accessToken,user);
        // 保存⽤户id到上下⽂
        RequestContext.put(Constant.USER_ID, user.getId());
//        保存角色信息到上下文
        RequestContext.put(Constant.USER_ROLE, user.getRole());
        return personalInformationVO;
    }

    @Override
    public PersonalInformationVO loginByPassword(String phone, String password) {
        // 根据⼿机号获取⽤户
        PersonalInformation user = baseMapper.getByPhone(phone);
        // 判断⽤户是否存在
        if (ObjectUtils.isEmpty(user)) {
            throw new ServerException(ErrorCode.USER_NOT_EXIST);
        } else if (!user.getPassword().equals(password)) {
            throw new ServerException(ErrorCode.PASSWORD_ERROR);
        }
        // 构造token
        return getUserLoginVO(user);
    }


    @Override
    public void logout() {
        // 从上下⽂中获取userId，然后获取redisKey
        String cacheKey = RedisKeys.getUserIdKey(RequestContext.getUserId());
        // 通过userId，获取redis中的 accessToken
        String accessToken = (String) redisCache.get(cacheKey);
        // 删除缓存中的 token
        redisCache.delete(cacheKey);
        // 删除缓存中的⽤户信息
        tokenStoreCache.deleteUser(accessToken);
    }


}
