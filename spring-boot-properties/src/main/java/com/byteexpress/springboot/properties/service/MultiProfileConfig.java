package com.byteexpress.springboot.properties.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 引入多配置文件测试
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 07:57
 * @Version V1.0
 */
@Slf4j
@Setter
@Component
public class MultiProfileConfig {
    @Value("multiprofile.name")
    private String name;
    @Value("multiprofile.type")
    private String type;

    public void print() {
        log.info("Property name: {}", name);
        log.info("Property type: {}", type);
    }
}
