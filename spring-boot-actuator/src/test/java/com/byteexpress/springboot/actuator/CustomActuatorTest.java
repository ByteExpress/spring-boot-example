package com.byteexpress.springboot.actuator;

import cn.hutool.json.JSONUtil;
import com.byteexpress.springboot.actuator.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * 自定义Actuator端点测试
 * @Author: ByteExpress
 * @Date: 2024/2/24 21:58
 * @Version V1.0
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomActuatorTest {
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
     * 测试get数据
     */
    @Test
    void testGetActuator() {
        exec("/myActuator/customPoint/1001");
    }

    /**
     * 测试post数据
     */
    @Test
    void testPostActuator() {
        User user = new User("2001", "测试用户", "11012345678");
        ResponseEntity<User> responseEntity = testRestTemplate.postForEntity("/myActuator/customPoint", user, User.class);
        if (HttpStatus.OK == responseEntity.getStatusCode() && null != responseEntity.getBody()) {
            log.info("success");
        }
    }

    /**
     * 测试put数据
     */
    @Test
    void testPutActuator() {
        User user = new User("1001", "测试用户", "11012345679");
        ResponseEntity<User> responseEntity = testRestTemplate.postForEntity("/myActuator/customPoint", user, User.class);
        if (HttpStatus.OK == responseEntity.getStatusCode() && null != responseEntity.getBody()) {
            log.info("success");
            log.info(JSONUtil.toJsonPrettyStr(responseEntity.getBody()));
        }
    }

}