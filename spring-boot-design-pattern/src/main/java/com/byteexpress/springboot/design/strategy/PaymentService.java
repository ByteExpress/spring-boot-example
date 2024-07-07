package com.byteexpress.springboot.design.strategy;

import org.springframework.stereotype.Service;

/**
 * <p>策略模式 (Strategy Pattern)</p>
 * 策略模式允许在运行时选择算法的行为。
 * 在Spring Boot中，可以通过依赖注入不同的策略实现来动态地改变程序的行为。
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:30
 * @Version V1.0
 */
@Service
public class PaymentService {
    private final PaymentStrategy paymentStrategy;

    public PaymentService(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.pay(amount);
    }
}