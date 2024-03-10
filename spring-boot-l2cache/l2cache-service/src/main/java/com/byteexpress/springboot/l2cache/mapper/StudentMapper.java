package com.byteexpress.springboot.l2cache.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.byteexpress.springboot.l2cache.domain.Student;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生 Mapper
 * @Author: ByteExpress
 * @Date: 2024/03/10 20:02
 * @Version V1.0
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
