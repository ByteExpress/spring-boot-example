package com.byteexpress.springboot.async.service.impl;

import com.byteexpress.springboot.async.service.IAsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 异步服务实现类
 * @Author: ByteExpress
 * @Date: 2024/4/6 16:11
 * @Version V1.0
 */
@Slf4j
@Service
public class AsyncServiceImpl implements IAsyncService {
    @Override
    public void task1() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        Thread.sleep(2000);
        long t2 = System.currentTimeMillis();
        log.info("task1 cost {} ms" , t2-t1);
    }

    @Override
    public void task2() throws InterruptedException {
        long t1 = System.currentTimeMillis();
        Thread.sleep(3000);
        long t2 = System.currentTimeMillis();
        log.info("task2 cost {} ms" , t2-t1);
    }
}
