package com.byteexpress.springboot.properties.service;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * 通过@ConfigurationProperties将Map配置注入到配置类
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 08:46
 * @Version V1.0
 */
@Setter
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "map.byclass")
public class MapConfigClass {

    private Map<String, String> property1;

    public void print() {
        System.out.println("Property1 Map: " + property1);
    }
}
