package com.byteexpress.springboot.event.listener;

import com.byteexpress.springboot.event.event.CustomEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 使用@EventListener来监听事件
 */
@Slf4j
@Component
public class CustomEventListener2 {
    /**
     * 默认是同步方法
     * @param event
     */
    @EventListener
    public void onApplicationEvent1(CustomEvent event) {
        log.info("接收到事件(@EventListener注解) : {}", event.getMessage());
    }

    /**
     * 需要异步可以搭配@Async实现
     * @param event
     */
    @Async
    @EventListener
    public void onApplicationEvent2(CustomEvent event) {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        log.info("接收到事件(@EventListener+@Async注解) : {}", event.getMessage());
    }
}