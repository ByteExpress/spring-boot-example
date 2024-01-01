package com.byteexpress.springboot.mybatisplus.controller;

import com.byteexpress.springboot.mybatisplus.domain.Student;
import com.byteexpress.springboot.mybatisplus.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生 Controller
 * @Author: ByteExpress
 * @Date: 2024/1/1 13:54
 * @Version V1.0
 */
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService iStudentService;

    @GetMapping
    public List<Student> getList() {
        List<Student> studentList = iStudentService.list();
        return studentList;
    }
}
