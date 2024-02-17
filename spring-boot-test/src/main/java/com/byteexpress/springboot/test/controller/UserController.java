package com.byteexpress.springboot.test.controller;

import cn.hutool.core.util.StrUtil;
import com.byteexpress.springboot.test.base.vo.R;
import com.byteexpress.springboot.test.domain.User;
import com.byteexpress.springboot.test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户 controller
 *
 * @Author: ByteExpress
 * @Date: 2023/12/30 09:58
 * @Version V1.0
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public R<List<User>> list() {
        List<User> userList = userService.all();
        return R.ok(userList);
    }

    @GetMapping("/{name}")
    public R<User> detail(@PathVariable("name") String name) {
        User user = userService.all().stream()
                .filter(e -> StrUtil.isBlank(name) || name.equals(e.getName()))
                .findFirst()
                .get();
        return R.ok(user);
    }

    @PostMapping
    public R<Object> add(@RequestBody User user) {
        User resultObj = userService.add(user);
        return R.ok(resultObj);
    }

    @PutMapping
    public R<Object> update(@RequestBody User user) {
        User resultObj = userService.update(user);
        return R.ok(resultObj);
    }

    @DeleteMapping
    public R<Object> update(@RequestBody List<String> ids) {
        userService.deleteByIds(ids);
        return R.ok("success");
    }

}