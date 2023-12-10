package com.byteexpress.springboot.redis.annotation;

import java.lang.annotation.*;

/**
 * 延时双删注解
 * @Author: ByteExpress
 * @Date: 2023-11-12 22:02:10
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface ReloadCache {
    String name() default "";
    /**
     * 延迟删除时间，默认1s
     * @return
     */
    long delayDelTime() default  1 * 1000;
}
