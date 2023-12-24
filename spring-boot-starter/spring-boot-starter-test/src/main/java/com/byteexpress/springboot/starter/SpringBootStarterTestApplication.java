package com.byteexpress.springboot.starter;

import com.byteexpress.springboot.starter.annotation.EnableBeLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 测试Starter 启动类
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:35
 * @Version V1.0
 */
@EnableBeLog
@SpringBootApplication
public class SpringBootStarterTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterTestApplication.class, args);
	}

}
