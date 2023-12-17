package com.byteexpress.springboot.attachment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件上传测试页面 controller
 *
 * @Author: ByteExpress
 * @Date: 2023/12/16 08:35
 * @Version V1.0
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
}