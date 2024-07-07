package com.byteexpress.springboot.design.singleton;

import org.springframework.stereotype.Service;

/**
 * <p>单例模式 (Singleton Pattern)</p>
 * 在Spring Boot中，通过Spring容器管理的Bean默认是单例的，例如@Service和@Component注解的类。
 * 可以利用单例模式确保在应用程序中只有一个实例，并通过依赖注入将其注入到需要使用的地方
 *
 * @Author: ByteExpress
 * @Date: 2024/7/7 15:30
 * @Version V1.0
 */
@Service
public class SingletonService {
    public void print(){
        System.out.println("this is singleton service");
    }
}