package com.byteexpress.springboot.exception.controller;

import com.byteexpress.springboot.exception.core.exception.ServiceException;
import com.byteexpress.springboot.exception.core.exception.ServiceExceptionNotTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: ByteExpress
 * @Date: 2024/3/31 08:54
 * @Version V1.0
 */
@RestController
@RequestMapping("/home")
public class HomeController {
    @GetMapping("/index1")
    public String index1() {
        boolean flag = true;
        if (flag) {
            throw new ServiceException("测试异常1");
        }
        return "index1!";
    }

    @GetMapping("/index2")
    public String index2() {
        boolean flag = true;
        if (flag) {
            throw new ServiceExceptionNotTrace("测试异常2");
        }
        return "index2!";
    }
}
