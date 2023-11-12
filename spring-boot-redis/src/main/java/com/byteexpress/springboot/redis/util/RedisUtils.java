package com.byteexpress.springboot.redis.util;

import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 * @Author: byteExpress
 * @Date: 2023-11-12 22:02:10
 */
@Service
public class RedisUtils {
    @Resource
    private RedisTemplate<String,String> redisTemplate; // 存储到redis的数据类型都是string

    /**RedisAutoConfiguration
     * 写入缓存+过期时间
     * @param key
     * @param value
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public boolean set( String key, String value, Long expireTime , TimeUnit timeUnit){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        operations.set(key,value);
        redisTemplate.expire(key,expireTime,timeUnit);
        return true;
    }

    /**
     * 通过key获取value
     * @param key
     * @return
     */
    public String get(String key){
        ValueOperations<String, String> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     * 批量删除 k-v
     * @param keys
     * @return
     */
    public boolean remove(final String... keys){
        for(String key : keys){
            if(redisTemplate.hasKey(key)){ //key存在就删除
                redisTemplate.delete(key);
            }
        }
        return true;
    }

}
