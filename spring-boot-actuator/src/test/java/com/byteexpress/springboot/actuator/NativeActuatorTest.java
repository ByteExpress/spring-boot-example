package com.byteexpress.springboot.actuator;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Map;

/**
 * 原生Actuator端点测试
 * @Author: ByteExpress
 * @Date: 2024/2/24 14:53
 * @Version V1.0
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NativeActuatorTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    private Map exec(String url) {
        Map result = testRestTemplate.getForObject(url, Map.class);
        System.out.println();
        System.out.println("url: " + url);
        System.out.println(JSONUtil.toJsonPrettyStr(result));
        return result;
    }

    /**
     * 查看所有端点信息
     */
    @Test
    void testActuator() {
        exec("/myActuator");
    }

    /**
     * 查看应用程序的环境变量
     */
    @Test
    void testActuatorEnv() {
        exec("/myActuator/env");
    }

    /**
     * 查看应用程序的健康状况
     */
    @Test
    void testActuatorHealth() {
        exec("/myActuator/health");
    }

    /**
     * 查看应用程序的信息
     */
    @Test
    void testActuatorInfo() {
        exec("/myActuator/info");
    }

    /**
     * 查看应用程序的性能指标
     */
    @Test
    void testActuatorMetrics() {
        exec("/myActuator/metrics");
    }

    /**
     * 查看和修改应用程序的日志级别
     */
    @Test
    void testActuatorLoggers() {
        exec("/myActuator/loggers");
    }


}