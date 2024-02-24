package com.byteexpress.springboot.actuator.custom;

import cn.hutool.core.util.StrUtil;
import com.byteexpress.springboot.actuator.domain.User;
import com.byteexpress.springboot.actuator.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@RestControllerEndpoint(id = "customPoint")
@Component
@RequiredArgsConstructor
public class CustomEndPoint {
    private final UserService userService;

    @GetMapping
    public User getUser(@Selector String id) {
        return userService.getById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.add(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User param) {
        User user = getUser(param.getId());
        Assert.isTrue(null != user, StrUtil.format("用户[id={}]不存在！", param.getId()));
        user.setName(Optional.ofNullable(param.getName()).orElse(user.getName()));
        user.setMobile(Optional.ofNullable(param.getMobile()).orElse(user.getName()));
        return userService.update(user);
    }
}