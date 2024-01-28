package com.byteexpress.springboot.webflux.controller;

import com.byteexpress.springboot.webflux.entity.User;
import com.byteexpress.springboot.webflux.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * 用户 controller
 *
 * @Author: ByteExpress
 * @Date: 2024/1/28 11:35
 * @Version V1.0
 */
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public Mono<User> getUser(@PathVariable("id") Long id) {
        return Mono.just(userService.getById(id));
    }
}
