package com.byteexpress.springboot.properties.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 随机值注入
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 09:16
 * @Version V1.0
 */
@Slf4j
@Setter
@Component
public class RandomConfigClass {
    @Value("${rd.randomString}")
    private String randomString;
    @Value("${rd.randomStringUuid}")
    private String randomStringUuid;
    @Value("${rd.randomLong}")
    private String randomLong;
    @Value("${rd.randomInt}")
    private String randomInt;
    @Value("${rd.randomIntInRange}")
    private String randomIntInRange;

    public void print() {
        log.info("Property randomString: {}", randomString);
        log.info("Property randomStringUuid: {}", randomStringUuid);
        log.info("Property randomLong: {}", randomLong);
        log.info("Property randomInt: {}", randomInt);
        log.info("Property randomIntInRange: {}", randomIntInRange);
    }
}
