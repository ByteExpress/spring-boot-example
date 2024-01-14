package com.byteexpress.springboot.mybatisplus.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.byteexpress.springboot.mybatisplus.base.domain.BaseCusEntity;
import lombok.Data;

/**
 * 自定义表单-教师类
 */
@Data
@TableName("cus_teacher")
public class CusTeacher extends BaseCusEntity {
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String gender;
    /**
     * 岗位
     */
    private String position;
}
