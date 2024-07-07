package com.byteexpress.springboot.design.factory;

import com.byteexpress.springboot.design.factory.service.base.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p>工厂模式 (Factory Pattern)</p>
 * 在Spring Boot中，可以使用工厂模式根据不同条件或配置创建不同的Bean实例。
 * 可以通过工厂方法或抽象工厂模式创建不同类型的Bean，以应对复杂的对象创建逻辑
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:59
 * @Version V1.0
 */
class FactoryTest {
    @Test
    public void testProductFactory() {
        ProductFactory factory = new ProductFactory();

        Product product1 = factory.createProduct("type1");
        Product product2 = factory.createProduct("type2");

        assertEquals("type1", product1.getType());
        assertEquals("type2", product2.getType());
    }
}