package com.byteexpress.springboot.starter.autoconfigure;

import com.byteexpress.springboot.starter.interceptor.LogInterceptor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * LogInterceptor拦截器配置类
 *
 * @Author: ByteExpress
 * @Date: 2023/12/24 10:09
 * @Version V1.0
 */
@AutoConfiguration
public class LogAutoConfigure implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
    }
}