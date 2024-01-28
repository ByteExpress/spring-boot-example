package com.byteexpress.springboot.webflux.service.impl;

import cn.hutool.core.map.MapUtil;
import com.byteexpress.springboot.webflux.entity.User;
import com.byteexpress.springboot.webflux.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 用户 服务实现类
 *
 * @Author: ByteExpress
 * @Date: 2024/01/28 21:57
 * @Version V1.0
 */
@Service
public class UserServiceImpl implements UserService {
    /** 用Map来模拟用户存储 */
    private static final Map<Long, User> USER_MAP = MapUtil.newHashMap();

    static {
        USER_MAP.put(1L, new User("阿飞","男","18112345678"));
    }

    @Override
    public User getById(Long userId) {
        return USER_MAP.get(userId);
    }
}
