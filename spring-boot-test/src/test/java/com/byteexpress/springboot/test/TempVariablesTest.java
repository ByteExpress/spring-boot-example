package com.byteexpress.springboot.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 临时属性
 * 覆盖源码配置文件中对应的属性值进行测试
 * 使用场景：需要临时修改配置进行测试，而不希望去修改源码配置文件中对应的属性值
 *
 * @Author: ByteExpress
 * @Date: 2024/2/8 14:22
 * @Version V1.0
 */
@Slf4j
@SpringBootTest(properties = {"switch.notice=true"})
class TempVariablesTest {
    @Value("${switch.notice}")
    private Boolean switchNotice;

    /**
     * 此用例，测试临时修改switch.notice值为true（application.yml配置文件中配置为false）
     */
    @Test
    void test01() {
        log.info("switchNotice={}", switchNotice);
    }
}