package com.byteexpress.springboot.design.factory;

import com.byteexpress.springboot.design.factory.service.Type1Product;
import com.byteexpress.springboot.design.factory.service.Type2Product;
import com.byteexpress.springboot.design.factory.service.base.Product;
import org.springframework.stereotype.Component;

/**
 * 产品工厂
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:44
 * @Version V1.0
 */
@Component
public class ProductFactory {
    public Product createProduct(String type) {
        if ("type1".equals(type)) {
            return new Type1Product();
        } else if ("type2".equals(type)) {
            return new Type2Product();
        }
        throw new IllegalArgumentException("Unknown service type: " + type);
    }
}