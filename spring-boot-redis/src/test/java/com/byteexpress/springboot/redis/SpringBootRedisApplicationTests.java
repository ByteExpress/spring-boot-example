package com.byteexpress.springboot.redis;

import com.byteexpress.springboot.redis.domain.Student;
import com.byteexpress.springboot.redis.service.IStudentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootRedisApplicationTests {
	@Resource
	private IStudentService iStudentService;

	@Test
	void contextLoads() {
		List<Student> list = iStudentService.list();
		for (Student student : list) {

		}
	}

}
