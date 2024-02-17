package com.byteexpress.springboot.test;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * MockMvc Restful API测试
 *
 * @Author: ByteExpress
 * @Date: 2024/2/8 14:22
 * @Version V1.0
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class MockMvcTests {

    //测试创建用户的功能
    @Test
    void testPostApi(@Autowired MockMvc mockMvc) throws Exception {
        String requestBody = "{\"id\": \"1004\", \"name\": \"dynamic man\", \"mobile\": \"13112345678\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value("dynamic man"))
                .andExpect(jsonPath("$.data.mobile").value("13112345678"));
    }

    //测试通过ID获取用户的功能
    @Test
    void testGetApi(@Autowired MockMvc mockMvc) throws Exception {
        //创建一个虚拟请求对象，封装请求的路径，并使用MockMVC对象发送对应请求
        //创建虚拟请求，访问/user
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/user");
        //执行对应的请求
        String result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.[0].name", Is.is("汤姆")))
                .andExpect(jsonPath("$.data.[0].gender").value("男"))
                .andReturn()
                .getResponse()
                .getContentAsString(Charset.defaultCharset());//防止中文乱码
        log.info(result);
    }

    //测试创建用户的功能
    @Test
    void testPutApi(@Autowired MockMvc mockMvc) throws Exception {
        String requestBody = "{\"id\": \"1001\", \"name\": \"update name\", \"mobile\": \"13112345678\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value("update name"))
                .andExpect(jsonPath("$.data.mobile").value("13112345678"));
    }

    //测试删除用户的功能
    @Test
    void testDeleteApi(@Autowired MockMvc mockMvc) throws Exception {
        String requestBody = JSONUtil.toJsonStr(Arrays.asList("1001", "1002"));
        mockMvc.perform(MockMvcRequestBuilders.delete("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk());
    }
}