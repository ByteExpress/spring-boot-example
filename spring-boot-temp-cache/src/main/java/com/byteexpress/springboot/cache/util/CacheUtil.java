package com.byteexpress.springboot.cache.util;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class CacheUtil<T> {
    public static <T> T getByCache(SFunction<T, ?> sFunction, Object key, Function<T, List<T>> listFunction) {
        List<T> list = listFunction.apply(null);
        for (T t : list) {
            Object apply = sFunction.apply(t);
            if (Objects.equals(apply, key)) {
                return t;
            }
        }
        return null;
    }
}
