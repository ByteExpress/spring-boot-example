package com.byteexpress.springboot.design.strategy;

import org.springframework.stereotype.Component;

/**
 * <p>xxxxx</p>
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:30
 * @Version V1.0
 */
@Component
public class PayPalPaymentStrategy implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        // PayPal payment logic
    }
}