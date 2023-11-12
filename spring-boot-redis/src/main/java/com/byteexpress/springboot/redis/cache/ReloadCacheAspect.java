package com.byteexpress.springboot.redis.cache;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 延时双删切面
 */
@Slf4j
@Aspect
@Component
public class ReloadCacheAspect {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.byteexpress.springboot.redis.cache.ReloadCache)")
    public void pointCut() {

    }

    /**
     * 环绕通知
     *
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("----------- 环绕通知 -----------");
        log.info("环绕通知的目标方法名：{}" + proceedingJoinPoint.getSignature().getName());

        Signature signature1 = proceedingJoinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature1;
        Method targetMethod = methodSignature.getMethod();
        ReloadCache reloadCache = targetMethod.getAnnotation(ReloadCache.class);

        //模糊删除redis的key值
        String name = reloadCache.name();
        fuzzyDelete(name);

        //执行加入双删注解的改动数据库的业务 即controller中的方法业务
        Object proceed = null;
        try {
            proceed = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 开一个线程 延迟delayDelTime秒
        // 在线程中延迟删除  同时将业务代码的结果返回 这样不影响业务代码的执行
        new Thread(() -> {
            try {
                Thread.sleep(reloadCache.delayDelTime());
                fuzzyDelete(name);
                log.info("-----------在线程中延迟删除完毕 -----------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        return proceed;//返回业务代码的值
    }

    /**
     * 模糊删除
     * @param key
     */
    private void fuzzyDelete(String key) {
        Set<String> keys = stringRedisTemplate.keys("*" + key + "*");
        stringRedisTemplate.delete(keys);
    }
}
