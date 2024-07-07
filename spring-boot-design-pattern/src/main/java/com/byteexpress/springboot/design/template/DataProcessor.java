package com.byteexpress.springboot.design.template;

import org.springframework.stereotype.Component;

/**
 * <p>模板方法模式 (Template Method Pattern)</p>
 * 模板方法模式定义一个操作中的算法的骨架，将一些步骤延迟到子类中实现。
 * 在Spring Boot中，可以使用抽象类定义模板方法，子类可以根据需要实现具体步骤。
 */
@Component
public abstract class DataProcessor {
    public void processData(String data) {
        // Common processing steps
        String processedData = process(data);

        // Post-processing steps
        postProcess(processedData);
    }

    protected abstract String process(String data);

    protected void postProcess(String processedData) {
        // Default implementation
    }
}

