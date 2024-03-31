package com.byteexpress.springboot.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExceptionApplication.class, args);
	}

}
