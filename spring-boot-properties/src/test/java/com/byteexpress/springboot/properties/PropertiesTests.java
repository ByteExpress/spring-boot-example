package com.byteexpress.springboot.properties;

import cn.hutool.json.JSONUtil;
import com.byteexpress.springboot.properties.service.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class PropertiesTests {
    /**
     * 通过@Value注解读取普通属性配置
     */
    @Test
    public void testBaseConfig(@Autowired BaseConfig baseConfig) {
        baseConfig.print();
    }

    /**
     * 通过@Value注解读取Map配置
     */
    @Test
    public void testMap(@Autowired MapConfig mapConfig) {
        mapConfig.print();
    }

    /**
     * 通过@ConfigurationProperties将Map配置注入到配置类
     */
    @Test
    public void testMapConfig(@Autowired MapConfigClass mapConfigClass) {
        mapConfigClass.print();
    }

    /**
     * 通过@Value注入List属性
     */
    @Test
    public void testList(@Autowired ListConfig listConfig) {
        listConfig.print();
    }

    /**
     * 通过@ConfigurationProperties将List配置注入到配置类
     */
    @Test
    public void testListConfig(@Autowired ListConfigClass listConfigClass) {
        listConfigClass.print();
    }

    /**
     * 通过注入获取Environment对象，然后再获取定义在配置文件的属性值
     */
    @Test
    public void testEnvironment(@Autowired EnvironmentConfig environmentConfig) {
        environmentConfig.print();
    }

    /**
     * 引入多配置文件测试
     */
    @Test
    public void testMultiProfileConfig(@Autowired MultiProfileConfig multiProfileConfig) {
        multiProfileConfig.print();
    }

    /**
     * 随机值注入
     */
    @Test
    public void testRandomConfigClass(@Autowired RandomConfigClass randomConfigClass) {
        randomConfigClass.print();
    }

    /**
     * SpEl动态注入
     */
    @Test
    public void testSpElConfig(@Autowired SpElConfig spElConfig) {
        System.out.println(JSONUtil.toJsonPrettyStr(spElConfig));
    }
}
