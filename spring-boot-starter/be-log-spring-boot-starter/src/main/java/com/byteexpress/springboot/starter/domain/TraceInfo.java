package com.byteexpress.springboot.starter.domain;

import lombok.Data;

/**
 * 日志实体
 * @Author: ByteExpress
 * @Date: 2023/12/24 10:08
 * @Version V1.0
 */
@Data
public class TraceInfo {
    public static final String TRACE_ID = "TRACE_ID";
    private long start;
    private String requestMethod;
    private String requestUri;
    private String traceId;
}