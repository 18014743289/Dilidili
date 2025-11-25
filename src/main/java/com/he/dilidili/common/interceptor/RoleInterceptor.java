package com.he.dilidili.common.interceptor;


import com.he.dilidili.common.cache.RequestContext;
import com.he.dilidili.common.exception.ErrorCode;
import com.he.dilidili.common.exception.ServerException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@AllArgsConstructor
@Component
public class RoleInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取用户角色
        Integer role = RequestContext.getUserRole();

        // 根据角色进行相应的验证
        if (!(role ==1)) {
            throw new ServerException(ErrorCode.FORBIDDEN);
        }

        return true;
    }
}
