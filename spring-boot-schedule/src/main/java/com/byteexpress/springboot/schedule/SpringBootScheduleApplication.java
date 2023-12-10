package com.byteexpress.springboot.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: ByteExpress
 * @Date: 2023/12/10 09:01
 * @Version V1.0
 */
@EnableScheduling
@SpringBootApplication
public class SpringBootScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootScheduleApplication.class, args);
	}

}
