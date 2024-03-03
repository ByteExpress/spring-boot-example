package com.byteexpress.springboot.properties.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 通过@Value注入List属性
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 08:10
 * @Version V1.0
 */
@Data
@Slf4j
@Component
public class ListConfig {

    @Value("#{'${list.byvalue.property1}'.split(',')}")
    private List<String> property1;

    @Value("#{'${list.byvalue.property1}'}")
    private String[] property3;

    @Value("#{'${list.byvalue.property2}'.split(',')}")
    private List<String> property2;

    public void print() {
        log.info("Property1 List:{}, size:{}", property1, property1.size());
        log.info("Property3 List:{}, size:{}", Arrays.stream(property3).toList(), property3.length);
        log.info("Property2 List:{}, size:{}", property2, property2.size());
    }
}
