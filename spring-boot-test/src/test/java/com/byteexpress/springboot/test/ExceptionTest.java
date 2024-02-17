package com.byteexpress.springboot.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * 异常测试：测试代码是否能够正确处理异常情况。
 * @Author: ByteExpress
 * @Date: 2024/2/17 14:04
 * @Version V1.0
 */
public class ExceptionTest {
    public int divide(int a, int b) {
        return a / b;
    }

    @Test
    public void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> this.divide(10, 0));
    }
}
