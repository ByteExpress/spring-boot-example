package com.byteexpress.springboot.starter.annotation;

import com.byteexpress.springboot.starter.autoconfigure.LogAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启动日志注解
 * @Author: ByteExpress
 * @Date: 2023/12/24 10:08
 * @Version V1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({LogAutoConfigure.class})
public @interface EnableBeLog {
    boolean value() default true;
}