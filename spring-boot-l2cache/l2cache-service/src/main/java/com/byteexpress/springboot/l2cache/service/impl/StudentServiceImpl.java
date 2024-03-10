package com.byteexpress.springboot.l2cache.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.byteexpress.springboot.l2cache.domain.Student;
import com.byteexpress.springboot.l2cache.mapper.StudentMapper;
import com.byteexpress.springboot.l2cache.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 学生Impl
 * @Author: ByteExpress
 * @Date: 2024/03/10 20:03
 * @Version V1.0
 */
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Override
    public Student getById(Long id) {
        log.info("从数据库中获取学生信息");
        return super.getById(id);
    }

    @Override
    public boolean updateById(Student student) {
        log.info("更新数据库中的学生信息");
        return super.updateById(student);
    }
}
