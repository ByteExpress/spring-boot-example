package com.byteexpress.springboot.actuator.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户实体类
 * @Author: ByteExpress
 * @Date: 2023/12/30 09:57
 * @Version V1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String id;
    private String name;
    private String mobile;
}
