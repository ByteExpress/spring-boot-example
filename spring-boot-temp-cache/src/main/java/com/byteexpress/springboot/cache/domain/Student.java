package com.byteexpress.springboot.cache.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class Student {
    private Long id;

    private String name;

    private String gender;
}
