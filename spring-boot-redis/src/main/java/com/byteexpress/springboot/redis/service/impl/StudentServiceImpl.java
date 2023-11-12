package com.byteexpress.springboot.redis.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteexpress.springboot.redis.domain.Student;
import com.byteexpress.springboot.redis.mapper.StudentMapper;
import com.byteexpress.springboot.redis.service.IStudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
