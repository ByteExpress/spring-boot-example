package com.byteexpress.springboot.webflux.service;

import com.byteexpress.springboot.webflux.entity.User;

/**
 * 用户 服务类
 *
 * @Author: ByteExpress
 * @Date: 2024/01/28 21:57
 * @Version V1.0
 */
public interface UserService {
    /**
     * 根据ID获取用户详情
     * @param userId
     * @return
     */
    User getById(Long userId);
}