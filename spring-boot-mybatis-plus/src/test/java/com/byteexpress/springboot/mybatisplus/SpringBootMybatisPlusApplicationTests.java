package com.byteexpress.springboot.mybatisplus;

import com.byteexpress.springboot.mybatisplus.domain.Student;
import com.byteexpress.springboot.mybatisplus.service.IStudentService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMybatisPlusApplicationTests {
	@Resource
	private IStudentService iStudentService;

	@Test
	void contextLoads() {
		List<Student> list = iStudentService.list();
		for (Student student : list) {
			System.out.println("name = " + student.getName());
		}
	}

}
