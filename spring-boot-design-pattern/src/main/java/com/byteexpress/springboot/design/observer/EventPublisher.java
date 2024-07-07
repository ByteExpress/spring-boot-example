package com.byteexpress.springboot.design.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * 观察者模式 (Observer Pattern)
 * 观察者模式用于定义对象间的一对多依赖关系，当一个对象的状态发生改变时，所有依赖它的对象都得到通知并自动更新。
 * 在Spring Boot中，可以使用事件驱动的方式实现观察者模式，例如使用Spring的事件机制
 */
@Component
public class EventPublisher {
    private final ApplicationEventPublisher publisher;

    public EventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void publishEvent(Object event) {
        publisher.publishEvent(event);
    }
}