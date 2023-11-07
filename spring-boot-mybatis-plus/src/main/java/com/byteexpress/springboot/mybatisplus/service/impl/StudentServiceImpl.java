package com.byteexpress.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteexpress.springboot.mybatisplus.domain.Student;
import com.byteexpress.springboot.mybatisplus.mapper.StudentMapper;
import com.byteexpress.springboot.mybatisplus.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
