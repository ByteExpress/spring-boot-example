package com.byteexpress.springboot.test;

import com.byteexpress.springboot.test.base.vo.R;
import com.byteexpress.springboot.test.domain.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;


/**
 * Mvc测试
 *
 * @Author: ByteExpress
 * @Date: 2024/2/17 08:53
 * @Version V1.0
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MvcTests {

    @Test
    public void getUserTest(@Autowired TestRestTemplate testRestTemplate) {
        R<User> result = testRestTemplate.getForObject("/user/汤姆", R.class);
        Assertions.assertThat(result.getCode()).isEqualTo(200);
        Assertions.assertThat(result.getMsg()).isNull();
    }

}