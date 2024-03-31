package com.byteexpress.springboot.exception.handler;

import com.byteexpress.springboot.exception.core.exception.ServiceException;
import com.byteexpress.springboot.exception.core.exception.ServiceExceptionNotTrace;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <p>全局异常处理</p>
 *
 * @Author: ByteExpress
 * @Date: 2024/3/31 08:59
 * @Version V1.0
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * <p>处理全局异常</p>
     * 没有指定异常类型，可以处理所有的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex) {
        // 处理异常的逻辑，可以返回自定义的错误信息或处理方式
        log.error("服务器发生错误，请联系管理员。", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("服务器发生错误，请联系管理员。");
    }

    /**
     * <p>处理自定义异常</p>
     * 指定异常类型，只处理ServiceException异常，打印堆栈信息
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> handleServiceException(ServiceException ex) {
        log.error("", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    /**
     * <p>处理自定义异常</p>
     * 指定异常类型，只处理ServiceExceptionNotTrace异常，不打印堆栈信息
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ServiceExceptionNotTrace.class)
    public ResponseEntity<String> handleServiceExceptionNotTrace(ServiceExceptionNotTrace ex) {
        log.error("{}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}