package com.byteexpress.springboot.exception.core.exception;

/**
 * 业务异常类，打印异常堆栈信息
 *
 * @Author: ByteExpress
 * @Date: 2024/3/31 08:59
 * @Version V1.0
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String code;

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
