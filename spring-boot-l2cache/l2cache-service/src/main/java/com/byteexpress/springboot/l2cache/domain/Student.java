package com.byteexpress.springboot.l2cache.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 学生实体类
 * @Author: ByteExpress
 * @Date: 2024/03/10 20:02
 * @Version V1.0
 */
@Data
@TableName("student")
public class Student implements Serializable {
    private static final long serialVersionUID = 42L;
    private Long id;

    private String name;

    private String gender;
}
