package com.byteexpress.springboot.event;

import cn.hutool.extra.spring.SpringUtil;
import com.byteexpress.springboot.event.publisher.CustomEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SpringBootEventApplicationTests {

    @Test
    public void publishCustomEvent() throws InterruptedException {
        String message = "测试消息";
        SpringUtil.getBean(CustomEventPublisher.class).publishCustomEvent(message);
    }

}
