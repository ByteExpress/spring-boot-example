package com.byteexpress.springboot.mybatisplus.service;

import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormQueryBo;
import com.byteexpress.springboot.mybatisplus.domain.bo.CusFormSaveBo;

import java.io.Serializable;
import java.util.List;

/**
 * 通用表单公共服务类
 * @Author: ByteExpress
 * @Date: 2024/1/13 07:59
 * @Version V1.0
 */
public interface CusService {
    /**
     * 新增表单
     * @param bo
     */
    Serializable add(String formKey, CusFormSaveBo bo);

    /**
     * 更新表单
     * @param bo
     */
    Boolean update(String formKey, CusFormSaveBo bo);

    /**
     * 表单列表
     * @param bo
     * @return
     */
    List list(String formKey, CusFormQueryBo bo);

    /**
     * 表单详情
     * @param formKey
     * @param id
     * @return
     */
    Object detail(String formKey, Long id);

    /**
     * 批量删除
     * @param formKey
     * @param ids
     */
    void delete(String formKey, List<Serializable> ids);
}
