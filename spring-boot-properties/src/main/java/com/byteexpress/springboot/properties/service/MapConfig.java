package com.byteexpress.springboot.properties.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 通过@Value注入Map属性
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 08:31
 * @Version V1.0
 */
@Component
public class MapConfig {

    @Value("#{${map.byvalue.property1}}")
    private Map<String, String> property1;

    public void print() {
        System.out.println("Property1 Map: " + property1);
    }
}
