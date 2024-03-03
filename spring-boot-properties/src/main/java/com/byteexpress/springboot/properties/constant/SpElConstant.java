package com.byteexpress.springboot.properties.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SpEl测试数据
 *
 * @Author: ByteExpress
 * @Date: 2024/3/3 11:59
 * @Version V1.0
 */
@Data
@Component
public class SpElConstant {
    private String name = "SpElConstant";
    private String nickname = "byteexpress";
    private int num = 100;
    private List<String> productList = new ArrayList<>() {{
        add("huaweiMate60Pro");
        add("iphone15");
        add("xiaomi14");
    }};
    private Map<String, String> productMap = new HashMap<>() {{
        put("huaweiMate60Pro", "6999");
        put("iphone15", "8999");
        put("xiaomi14", "5999");
    }};
    private List<Sales> salesList = new ArrayList<>() {{
        add(new Sales("huaweiMate60Pro", 5000L));
        add(new Sales("iphone15", 3000L));
        add(new Sales("xiaomi14", 998L));
    }};

    public String showProperty() {
        return "showProperty-无参数";
    }

    public String showProperty(String name) {
        return "showProperty-" + name;
    }

    @Data
    @AllArgsConstructor
    public static class Sales {
        /**
         * 商品名称
         */
        private String productName;
        /**
         * 销量
         */
        private long salesVolume;
    }
}