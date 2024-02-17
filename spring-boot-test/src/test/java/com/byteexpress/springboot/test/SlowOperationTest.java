package com.byteexpress.springboot.test;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTimeout;

/**
 * 超时测试：测试代码是否在规定的时间内完成。
 *
 * @Author: ByteExpress
 * @Date: 2024/2/8 14:22
 * @Version V1.0
 */
public class SlowOperationTest {

    @Test
    public void testSlowOperation() {
        SlowOperation slowOperation = new SlowOperation();
        assertTimeout(Duration.ofSeconds(5), () -> slowOperation.doSomethingSlow());
    }

    class SlowOperation{
        public void doSomethingSlow() throws InterruptedException {
            TimeUnit.SECONDS.sleep(6);
        }
    }

}
