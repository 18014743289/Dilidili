package com.he.dilidili.utils;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.json.JSONObject;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import cn.hutool.jwt.RegisteredPayload;
import com.he.dilidili.common.constant.Constant;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class JwtUtil {
    /**
     * 盐值很重要，不能泄漏，且每个项⽬都应该不⼀样，可以放到配置⽂件中
     */
    private static final String KEY = "Dilidili";

    public static String createToken(Integer userId) {
        DateTime now = DateTime.now();
        // 超时时间
        DateTime expTime = now.offsetNew(DateField.HOUR, 48);
        Map<String, Object> payload = new HashMap<>();
        // 签发时间
        payload.put(RegisteredPayload.ISSUED_AT, now);
        // 过期时间
        payload.put(RegisteredPayload.EXPIRES_AT, expTime);
        // ⽣效时间
        payload.put(RegisteredPayload.NOT_BEFORE, now);
        // ⾃定义载荷
        payload.put(Constant.USER_ID, userId);
        String token = JWTUtil.createToken(payload, KEY.getBytes(StandardCharsets.UTF_8));
        log.info("⽣成 JWT token：{}", token);
        return token;
    }

    public static boolean validate(String token) {
        if (StringUtils.isBlank(token)) {
            log.error("Token为空");
            return false;
        }

        try {
            JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes(StandardCharsets.UTF_8));

            // 1. 验证签名
            if (!jwt.verify()) {
                log.error("JWT签名验证失败");
                return false;
            }

            // 2. 获取过期时间（安全的方式）
            Object expObj = jwt.getPayload("exp");
            if (expObj == null) {
                log.error("JWT缺少过期时间");
                return false;
            }

            long expTime;
            if (expObj instanceof Number) {
                expTime = ((Number) expObj).longValue();
            } else {
                // 尝试字符串转换
                try {
                    expTime = Long.parseLong(expObj.toString());
                } catch (NumberFormatException e) {
                    log.error("过期时间格式错误: {}", expObj);
                    return false;
                }
            }

            // 3. 检查是否过期（60秒容差）
            long currentTime = System.currentTimeMillis() / 1000;
            boolean notExpired = currentTime <= expTime + 60;

            if (!notExpired) {
                log.warn("JWT已过期, 过期时间: {}, 当前时间: {}", expTime, currentTime);
            }

            return notExpired;

        } catch (Exception e) {
            log.error("JWT token 校验异常：{}", e.getMessage());
            return false;
        }
    }

    public static JSONObject getJSONObject(String token) {
        JWT jwt = JWTUtil.parseToken(token).setKey(KEY.getBytes());
        JSONObject payloads = jwt.getPayloads();
        payloads.remove(RegisteredPayload.ISSUED_AT);
        payloads.remove(RegisteredPayload.EXPIRES_AT);
        payloads.remove(RegisteredPayload.NOT_BEFORE);
        log.info("根据 token 获取原始内容：{}", payloads);
        return payloads;
    }

    public static String getAccessToken(HttpServletRequest request) {
        String accessToken = request.getHeader("Authorization");
        if (StringUtils.isBlank(accessToken)) {
            accessToken = request.getParameter("accessToken");
        }
        return accessToken;
    }
}