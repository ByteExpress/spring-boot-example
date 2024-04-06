package com.byteexpress.springboot.async.controller;

import com.byteexpress.springboot.async.service.IAsyncService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步Controller
 * @Author: ByteExpress
 * @Date: 2024/4/6 16:15
 * @Version V1.0
 */
@RestController
@RequestMapping("/async")
@Slf4j
public class AsyncController {
    @Resource
    private IAsyncService iAsyncService;

    @RequestMapping("/task")
    public void task() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        iAsyncService.task1();
        iAsyncService.task2();
        Thread.sleep(1000);
        long t2 = System.currentTimeMillis();
        log.info("main cost {} ms", t2 - t1);
    }
}