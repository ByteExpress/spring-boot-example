package com.byteexpress.springboot.properties.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通过注入获取Environment对象，然后再获取定义在配置文件的属性值
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 07:58
 * @Version V1.0
 */
@Slf4j
@Component
public class EnvironmentConfig {
    @Resource
    Environment environment;

    public void print() {
        String property1 = environment.getProperty("list.byclass.property1");
        List<String> property2 = environment.getProperty("list.byclass.property1", List.class);
        log.info("String Property:{}", property1);
        log.info("List Property:{}, size:{}", property2, property2.size());
    }
}