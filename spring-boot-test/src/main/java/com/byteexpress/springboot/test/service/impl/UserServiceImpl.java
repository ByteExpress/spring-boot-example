package com.byteexpress.springboot.test.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.byteexpress.springboot.test.domain.User;
import com.byteexpress.springboot.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * 用户 serviceImpl
 *
 * @Author: ByteExpress
 * @Date: 2024/2/17 08:11
 * @Version V1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private Map<String, User> userMap = new HashMap<>() {{
        put("1001", new User("1001", "汤姆", "17788996600"));
        put("1002", new User("1002", "林肯", "17788996601"));
        put("1003", new User("1003", "杨哥", "17788996602"));
    }};

    @Override
    public List<User> all() {
        return userMap.values().stream().toList();
    }

    @Override
    public int getTotal() {
        log.info("run into getTotal()");
        return 3;
    }

    @Override
    public User add(User user) {
        userMap.put(user.getId(), user);
        return userMap.get(user.getId());
    }

    @Override
    public User update(User user) {
        if (StrUtil.isBlank(user.getId())) {
            return user;
        }
        User dbUser = userMap.get(user.getId());
        if (null == dbUser) {
            return user;
        }
        dbUser.setName(Optional.ofNullable(user.getName()).orElse(dbUser.getName()));
        dbUser.setMobile(Optional.ofNullable(user.getMobile()).orElse(dbUser.getMobile()));
        userMap.put(user.getId(), dbUser);

        return userMap.get(user.getId());
    }

    @Override
    public void deleteByIds(List<String> ids) {
        if (CollectionUtil.isEmpty(ids)) {
            return;
        }
        for (String id : ids) {
            userMap.remove(id);
        }
    }
}
