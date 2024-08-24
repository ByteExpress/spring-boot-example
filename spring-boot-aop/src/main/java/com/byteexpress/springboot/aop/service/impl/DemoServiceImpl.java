package com.byteexpress.springboot.aop.service.impl;

import com.byteexpress.springboot.aop.service.IDemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Demo服务实现类
 *
 * @Author: ByteExpress
 * @Date: 2024/08/24 14:34
 * @Version V1.0
 */
@Slf4j
@Service
public class DemoServiceImpl implements IDemoService {

    @Override
    public void exec() {
        try {
            System.out.println("executing method");
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
