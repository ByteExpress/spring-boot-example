package com.byteexpress.springboot.aop.controller;

import com.byteexpress.springboot.aop.annotation.MethodEnhance;
import com.byteexpress.springboot.aop.service.IDemoService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Demo Controller
 *
 * @Author: ByteExpress
 * @Date: 2024/08/24 14:34
 * @Version V1.0
 */
@RestController
@RequestMapping("/aop")
@Slf4j
public class DemoController {
    @Resource
    private IDemoService iDemoService;

    @MethodEnhance
    @RequestMapping
    public void exec() {
        iDemoService.exec();
    }
}