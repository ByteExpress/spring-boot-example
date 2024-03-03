package com.byteexpress.springboot.properties.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 通过@Value注解读取扩展配置文件属性
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 07:39
 * @Version V1.0
 */
@Slf4j
@Component
public class ExtProfilesConfig {

    @Value("${ext.location}")
    private String extLocation;

    public void print() {
        log.info("Properties extLocation: {}", extLocation);
    }
}