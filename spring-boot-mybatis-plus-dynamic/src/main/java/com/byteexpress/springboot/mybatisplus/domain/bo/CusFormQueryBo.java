package com.byteexpress.springboot.mybatisplus.domain.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 通用表单查询BO
 * @Author: ByteExpress
 * @Date: 2024/1/13 08:25
 * @Version V1.0
 */
@Getter
@Setter
public class CusFormQueryBo {
    /**
     * 搜索字段
     */
    private String searchKey;
}
