package com.byteexpress.springboot.l2cache.base.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一结果包装类
 * @Author: ByteExpress
 * @Date: 2024/03/10 20:02
 * @Version V1.0
 */
@Data
@AllArgsConstructor
public class R<T> implements Serializable {

    private boolean success;

    private int code;

    private String msg;

    private T data;


    /**
     * 成功
     *
     * @return
     */
    public static R ok() {
        return new R(true, 200, "success", null);
    }


    /**
     * 成功
     *
     * @param data
     * @return
     */
    public static <T> R ok(T data) {
        return new R(true, 200, "success", data);
    }

    /**
     * 失败
     *
     * @param code
     * @param msg
     * @return
     */
    public static R fail(int code, String msg) {
        return new R(false, code, msg, null);
    }

    /**
     * 失败
     *
     * @param msg
     * @return
     */
    public static R fail(String msg) {
        return fail(500, msg);
    }
}
