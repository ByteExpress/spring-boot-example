package com.byteexpress.springboot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: ByteExpress
 * @Date: 2024/11/21 09:01
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.byteexpress.springboot.cache.mapper")
public class SpringBootTempCacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTempCacheApplication.class, args);
	}

}
