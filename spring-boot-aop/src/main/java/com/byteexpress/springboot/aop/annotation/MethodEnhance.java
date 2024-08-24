package com.byteexpress.springboot.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法增强注解
 */
@Target(ElementType.METHOD) // 注解可以用于方法
@Retention(RetentionPolicy.RUNTIME) // 注解在运行时可用
public @interface MethodEnhance {

}
