package com.byteexpress.springboot.exception.core.exception;

/**
 * 业务异常类，不打印堆栈信息
 *
 * @Author: ByteExpress
 * @Date: 2024/3/31 08:59
 * @Version V1.0
 */
public class ServiceExceptionNotTrace extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ServiceExceptionNotTrace() {
        super();
    }

    public ServiceExceptionNotTrace(String message) {
        super(message);
    }

    public ServiceExceptionNotTrace(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceExceptionNotTrace(Throwable cause) {
        super(cause);
    }

    protected ServiceExceptionNotTrace(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
