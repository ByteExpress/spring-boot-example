package com.byteexpress.springboot.event.publisher;

import com.byteexpress.springboot.event.event.CustomEvent;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class CustomEventPublisher {
    @Resource
    private ApplicationEventPublisher eventPublisher;

    public void publishCustomEvent(final String message) throws InterruptedException {
        log.info("Publishing custom event start. ");
        CustomEvent customEvent = new CustomEvent(this, message);
        eventPublisher.publishEvent(customEvent);
        log.info("Publishing custom event start. ");
        TimeUnit.SECONDS.sleep(3000);
    }
}