package com.byteexpress.springboot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @Author: ByteExpress
 * @Date: 2024/4/6 16:08
 * @Version V1.0
 */
//@EnableAspectJAutoProxy // spring-boot-starter-aop依赖会自动启用AspectJ自动代理，不需要手动开启
@SpringBootApplication
public class SpringBootAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

}
