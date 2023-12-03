package com.byteexpress.springboot.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEventApplication.class, args);
	}

}
