package com.he.dilidili.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.github.yulichang.interceptor.MPJInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = {"com.he.dilidili.mapper"})
public class MybatisPlusConfig {

    /**
     * 配置 MPJInterceptor（MyBatis-Plus-Join 拦截器）
     */
    @Bean
    public MPJInterceptor mpjInterceptor() {
        return new MPJInterceptor();
    }

}