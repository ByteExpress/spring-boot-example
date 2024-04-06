package com.byteexpress.springboot.async.service;

import org.springframework.scheduling.annotation.Async;

/**
 * 异步服务接口
 * @Author: ByteExpress
 * @Date: 2024/4/6 16:09
 * @Version V1.0
 */
public interface IAsyncService {
    @Async
    void task1() throws InterruptedException;

    @Async
    void task2() throws InterruptedException;
}
