package com.byteexpress.springboot.mybatisplus.util;

import com.baomidou.mybatisplus.core.toolkit.LambdaUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.support.LambdaMeta;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.apache.ibatis.reflection.property.PropertyNamer;

/**
 * 属性工具类
 * @Author: ByteExpress
 * @Date: 2024/1/13 14:28
 * @Version V1.0
 */
public class FieldUtil {
    public static <T> String getJavaField(SFunction<T, ?> func){
        LambdaMeta meta = LambdaUtils.extract(func);
        return PropertyNamer.methodToProperty(meta.getImplMethodName());
    }

    public static <T> String getSqlField(SFunction<T, ?> func){
        return StringUtils.camelToUnderline(getJavaField(func));
    }
}
