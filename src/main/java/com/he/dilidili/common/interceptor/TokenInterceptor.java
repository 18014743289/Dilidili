package com.he.dilidili.common.interceptor;


import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.cache.TokenStoreCache;
import com.he.dilidili.common.constant.Constant;
import com.he.dilidili.common.exception.ErrorCode;
import com.he.dilidili.common.exception.ServerException;
import com.he.dilidili.model.entity.PersonalInformation;
import com.he.dilidili.model.vo.PersonalInformationVO;
import com.he.dilidili.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@AllArgsConstructor
@Component
public class TokenInterceptor implements HandlerInterceptor {
    private final TokenStoreCache tokenStoreCache;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取token
        String accessToken = JwtUtil.getAccessToken(request);
        if (StringUtils.isBlank(accessToken)) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        PersonalInformationVO user = tokenStoreCache.getUser(accessToken);
        // 校验token
        if (!JwtUtil.validate(accessToken)||user == null) {
            throw new ServerException(ErrorCode.UNAUTHORIZED);
        }
        // 保存⽤户id到上下⽂
        RequestContext.put(Constant.USER_ID, user.getId());
//        保存角色信息到上下文
        RequestContext.put(Constant.USER_ROLE, user.getRole());
        return true;
    }
}
