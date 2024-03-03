package com.byteexpress.springboot.properties.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通过@Value注解读取普通属性
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 07:10
 * @Version V1.0
 */
@Slf4j
@Component
public class BaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${server.port}")
    private int serverPort;

    public void print() {
        log.info("Database URL: {}", dbUrl);
        log.info("Server Port: {}", serverPort);
    }
}