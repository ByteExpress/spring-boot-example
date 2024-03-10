package com.byteexpress.springboot.l2cache.web2;

import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.byteexpress")
@EnableMethodCache(basePackages = "com.byteexpress.springboot.l2cache")
@MapperScan("com.byteexpress.springboot.l2cache.mapper")
public class SpringBootL2cacheWeb2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootL2cacheWeb2Application.class, args);
	}

}
