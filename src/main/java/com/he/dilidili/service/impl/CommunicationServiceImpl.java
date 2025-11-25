package com.he.dilidili.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloopen.rest.sdk.BodyType;
import com.cloopen.rest.sdk.CCPRestSmsSDK;
import com.he.dilidili.common.cache.RedisCache;
import com.he.dilidili.common.cache.RedisKeys;
import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.cache.TokenStoreCache;
import com.he.dilidili.common.config.CloopenConfig;
import com.he.dilidili.common.exception.ErrorCode;
import com.he.dilidili.common.exception.ServerException;
import com.he.dilidili.mapper.PersonalInformationMapper;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.service.CommunicationService;
import com.he.dilidili.utils.CommonUtils;
import com.he.dilidili.utils.UpLoadUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Set;
import java.util.UUID;


@Slf4j
@Service
@AllArgsConstructor
public class CommunicationServiceImpl extends ServiceImpl<PersonalInformationMapper, PersonalInformation> implements CommunicationService {
    private final CloopenConfig cloopenConfig;
    private final RedisCache redisCache;
    private final TokenStoreCache tokenStoreCache;
    private final UpLoadUtils upLoadUtils;

    @Override
    public void sendSms(String phone) {
        // 校验⼿机号合法性
        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }
        // ⽣成随机验证码
        int code = CommonUtils.generateCode();
        // redis缓存验证码
        redisCache.set(RedisKeys.getSmsKey(phone), code, 60);
        // 调⽤内部⽅法发送短信
        boolean result = cloopenSendSms(phone, code);
        if (result) {
            log.info(" ============= 短信发送成功 ============= ");
        }
    }

    private boolean cloopenSendSms(String phone, int code) {
        try {
            log.info(" ============= 创建短信发送通道中 ============= \nphone is {},code is {}", phone, code);
            CCPRestSmsSDK sdk = getSmsSDK();
            String templateId = cloopenConfig.getTemplateId();
            String[] datas = {String.valueOf(code), "1"};
            HashMap<String, Object> result = sdk.sendTemplateSMS(phone, templateId, datas, "1234", UUID.randomUUID().toString());
            if ("000000".equals(result.get("statusCode"))) {
                // 正常返回输出data包体信息（map）
                HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for (String key : keySet) {
                    Object object = data.get(key);
                    log.info("{} = {}", key, object);
                }
            } else {
                // 异常返回输出错误码和错误信息
                log.error("错误码={} 错误信息= {}", result.get("statusCode")
                        , result.get("statusMsg"));
                throw new ServerException(ErrorCode.CODE_SEND_FAIL);
            }
        } catch (Exception e) {
            throw new ServerException(ErrorCode.CODE_SEND_FAIL);
        }
        return true;
    }

    private CCPRestSmsSDK getSmsSDK() {
        String serverIp = cloopenConfig.getServerIp();
        // 请求端⼝
        String serverPort = cloopenConfig.getPort();
        // 主账号,登陆云通讯⽹站后,可在控制台⾸⻚看到开发者主账号ACCOUNT SID和主账号令牌AUTH TOKEN

        String accountSId = cloopenConfig.getAccountSId();
        String accountToken = cloopenConfig.getAccountToken();
        // 请使⽤管理控制台中已创建应⽤的APPID
        String appId = cloopenConfig.getAppId();
        CCPRestSmsSDK sdk = new CCPRestSmsSDK();
        sdk.init(serverIp, serverPort);
        sdk.setAccount(accountSId, accountToken);
        sdk.setAppId(appId);
        sdk.setBodyType(BodyType.Type_JSON);
        return sdk;
    }

    @Override
    public String bindPhone(String phone, String code, String accessToken) {
        PersonalInformationVO userLogin = validateUpdate(phone, code, accessToken);
        // 判断新⼿机号是否存在⽤户
        if (ObjectUtils.isNotEmpty(baseMapper.getByPhone(phone))) {
            // 存在⽤户，并且不是当前⽤户，抛出异常
            if (!userLogin.getId().equals(baseMapper.getByPhone(phone).getId())) {
                throw new ServerException(ErrorCode.PHONE_IS_EXIST);
            }
            // 存在⽤户，并且是当前⽤户，提示⽤户⼿机号相同
            if (userLogin.getPhone().equals(phone)) {
                throw new ServerException(ErrorCode.THE_SAME_PHONE);
            }
        }
        // 重新设置⼿机号
        PersonalInformation user = baseMapper.selectById(userLogin.getId());
        user.setPhone(phone);
        if (baseMapper.updateById(user) < 1) {
            throw new ServerException(ErrorCode.OPERATION_FAIL);
        }
        return accessToken;
    }

    @Override
    public String uploadAvatar(MultipartFile file) {
        String returnImgUrl = upLoadUtils.uploadFile(file);
        Integer userId = RequestContext.getUserId();
        //将用户头像更新到数据库
        PersonalInformation user = new PersonalInformation();
        user.setId(userId);
        user.setAvatar(returnImgUrl);
        baseMapper.updateById(user);
        return returnImgUrl;
    }

    @Override
    public String updatePassword(String phone, String code, String password, String accessToken) {
        PersonalInformationVO userInfo = validateUpdate(phone,code, accessToken);
        // 更新密码
        PersonalInformation user = baseMapper.selectById(userInfo.getId());
        user.setPassword(password);
        if (baseMapper.updateById(user) < 1) {
            throw new ServerException(ErrorCode.OPERATION_FAIL);
        }
        return accessToken;
    }

    private PersonalInformationVO validateUpdate(String phone, String code, String accessToken) {
        // 简单校验⼿机号合法性
        if (!CommonUtils.checkPhone(phone)) {
            throw new ServerException(ErrorCode.PARAMS_ERROR);
        }
        // 获取⼿机验证码，校验验证码正确性
        String redisCode = redisCache.get(RedisKeys.getSmsKey(phone)).toString();
        if (ObjectUtils.isEmpty(redisCode) || !redisCode.equals(code)) {
            throw new ServerException(ErrorCode.SMS_CODE_ERROR);
        }
        // 删除验证码缓存
        redisCache.delete(RedisKeys.getSmsKey(phone));
        return tokenStoreCache.getUser(accessToken);
    }
}
