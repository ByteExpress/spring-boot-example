package com.byteexpress.springboot.test.service;

import com.byteexpress.springboot.test.domain.User;

import java.util.List;

/**
 * 用户 service
 * @Author: ByteExpress
 * @Date: 2024/2/17 08:05
 * @Version V1.0
 */
public interface UserService {
    /**
     * 获取所有用户
     * @return
     */
    List<User> all();

    /**
     * 获取用户总数
     * @return
     */
    int getTotal();

    /**
     * 新增用户
     * @param user
     */
    User add(User user);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    User update(User user);

    /**
     * 根据ID批量删除
     * @param ids
     */
    void deleteByIds(List<String> ids);
}
