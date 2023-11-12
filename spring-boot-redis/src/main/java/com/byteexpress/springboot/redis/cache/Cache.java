package com.byteexpress.springboot.redis.cache;

import java.lang.annotation.*;

/**
 * 自定义注解类Cache
 * @Author: byteExpress
 * @Date: 2023-11-12 22:02:10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Cache {

    /**
     * 过期时间，默认60s
     * @return
     */
    long expire() default 2 * 60 * 1000;

    /**
     * 缓存标识name
     * @return
     */
    String name() default "";

}
