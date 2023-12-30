package com.byteexpress.springboot.thymeleaf.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户实体类
 * @Author: ByteExpress
 * @Date: 2023/12/30 09:57
 * @Version V1.0
 */
@Getter
@Setter
public class User {
    private String name;
    private String gender;
    private String mobile;

    public User(String name, String gender, String mobile) {
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
    }
}
