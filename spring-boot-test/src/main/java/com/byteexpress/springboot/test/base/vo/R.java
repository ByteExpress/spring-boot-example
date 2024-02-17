package com.byteexpress.springboot.test.base.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * 响应参数实体
 *
 * @Author: ByteExpress
 * @Date: 2024/1/13 08:14
 * @Version V1.0
 */
@Getter
@Setter
public class R<T> {
    private int code;
    private String msg;
    private T data;

    public R(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> R ok(T data) {
        return new R(HttpStatus.OK.value(), data);
    }

    public static <T> R fail(T data) {
        return new R(HttpStatus.INTERNAL_SERVER_ERROR.value(), data);
    }
}
