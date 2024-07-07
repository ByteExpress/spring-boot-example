package com.byteexpress.springboot.design.factory.service;

import com.byteexpress.springboot.design.factory.service.base.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 产品1
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:43
 * @Version V1.0
 */
@Slf4j
@Service
public class Type1Product implements Product {
    @Override
    public String getType() {
        return "type1";
    }
}
