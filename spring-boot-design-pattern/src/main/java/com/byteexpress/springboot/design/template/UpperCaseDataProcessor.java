package com.byteexpress.springboot.design.template;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseDataProcessor extends DataProcessor {
    @Override
    protected String process(String data) {
        return data.toUpperCase();
    }
}
