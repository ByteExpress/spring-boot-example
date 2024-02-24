package com.byteexpress.springboot.actuator.controller;

import com.byteexpress.springboot.actuator.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试页面 controller
 *
 * @Author: ByteExpress
 * @Date: 2023/12/30 09:58
 * @Version V1.0
 */
@Controller
@RequestMapping("/")
public class UserController {

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("汤姆", "男", "17788996600"));
        userList.add(new User("林肯", "女", "17788996601"));
        userList.add(new User("杨哥", "女", "17788996602"));
        model.addAttribute(userList);
        return "index";
    }
}