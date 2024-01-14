package com.byteexpress.springboot.mybatisplus.domain.bo;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * 通用表单请求BO
 *
 * @Author: ByteExpress
 * @Date: 2024/1/13 08:04
 * @Version V1.0
 */
@Getter
@Setter
public class CusFormSaveBo {
    private Map<String, Object> table;
}
