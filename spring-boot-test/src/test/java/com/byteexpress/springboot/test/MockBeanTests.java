package com.byteexpress.springboot.test;

import com.byteexpress.springboot.test.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * MockBean测试
 *
 * @Author: ByteExpress
 * @Date: 2024/2/17 08:05
 * @Version V1.0
 */
@SpringBootTest
class MockBeanTests {

    /**
     * 使用MockBean则不会调用实际的Service方法，可以断点或者观察日志查看
     */
    @MockBean
//    @Autowired
    private UserService userService;

    @Test
    @DisplayName("getTotalShow")
    public void getTotal() {
        BDDMockito.given(this.userService.getTotal()).willReturn(88);
        Assertions.assertThat(this.userService.getTotal()).isEqualTo(88);
    }

}