package com.byteexpress.springboot.cache.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteexpress.springboot.cache.domain.Student;
import com.byteexpress.springboot.cache.mapper.StudentMapper;
import com.byteexpress.springboot.cache.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
