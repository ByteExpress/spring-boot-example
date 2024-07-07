package com.byteexpress.springboot.design.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class MyEventListener {
    @EventListener
    public void handleEvent(MyCustomEvent event) {
        // Event handling logic
    }
}