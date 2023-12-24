package com.byteexpress.springboot.starter.controller;

import com.byteexpress.springboot.starter.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试Starter controller
 *
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:35
 * @Version V1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping("/index")
    @Log(desc = "测试日志Starter")
    public String index() {
        return "index";
    }
}