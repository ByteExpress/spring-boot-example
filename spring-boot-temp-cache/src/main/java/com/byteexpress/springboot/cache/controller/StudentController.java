package com.byteexpress.springboot.cache.controller;

import com.byteexpress.springboot.cache.domain.Student;
import com.byteexpress.springboot.cache.service.IStudentService;
import com.byteexpress.springboot.cache.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学生 Controller
 *
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
        Object byCache = CacheUtil.getByCache(Student::getId, 1723528775107063809L, (key) -> {
            return iStudentService.list();
        });
        List<Student> studentList = iStudentService.list();
        return studentList;
    }
}
