package com.byteexpress.springboot.event.listener;

import com.byteexpress.springboot.event.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 通过实现ApplicationListener接口的方式来监听事件
 */
@Slf4j
@Component
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        log.info("接收到事件(实现ApplicationListener接口) : {}", event.getMessage());
    }
}