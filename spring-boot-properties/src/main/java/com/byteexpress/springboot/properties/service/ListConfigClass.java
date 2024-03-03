package com.byteexpress.springboot.properties.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * 通过@ConfigurationProperties将List配置注入到配置类
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 08:15
 * @Version V1.0
 */
@Slf4j
@Setter
//指定配置文件，若只有一个，可不配置
@PropertySource("classpath:application.yml")
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "list.byclass")
public class ListConfigClass {

    private List<String> property1;
    private List<Integer> property2;
    private List<String> property3;

    public void print() {
        log.info("Property1 List:{}, size:{}", property1, property1.size());
        log.info("Property2 List:{}, size:{}", property2, property2.size());
        log.info("Property3 List:{}, size:{}", property3, property3.size());
    }
}
