package com.byteexpress.springboot.aop.aspect;

import com.byteexpress.springboot.aop.annotation.MethodEnhance;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MethodEnhanceAspect {

    @Before("@annotation(methodEnhance)") // 在带有@MethodEnhance注解的方法执行前
    public void methodStart(JoinPoint joinPoint, MethodEnhance methodEnhance) {
        System.out.println("Start executing method: " + joinPoint.getSignature().getName());
    }

    @After("@annotation(methodEnhance)") // 在带有@MethodEnhance注解的方法执行后
    public void methodEnd(JoinPoint joinPoint, MethodEnhance methodEnhance) {
        System.out.println("Finished executing method: " + joinPoint.getSignature().getName());
        System.out.println();
    }
}
