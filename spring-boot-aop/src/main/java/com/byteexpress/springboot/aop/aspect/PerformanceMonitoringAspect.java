package com.byteexpress.springboot.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitoringAspect {

    @Around("execution(* com.byteexpress.springboot.aop.service.*.*(..))") // 切点，匹配指定包下的所有方法
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); // 记录开始时间

        Object proceed = joinPoint.proceed(); // 执行目标方法

        long elapsedTime = System.currentTimeMillis() - startTime; // 计算执行时长
        System.out.println(joinPoint.getSignature() + " executed in " + elapsedTime + "ms");

        return proceed;
    }
}
