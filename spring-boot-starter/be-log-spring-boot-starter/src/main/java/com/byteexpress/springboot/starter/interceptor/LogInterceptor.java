package com.byteexpress.springboot.starter.interceptor;

import com.byteexpress.springboot.starter.annotation.Log;
import com.byteexpress.springboot.starter.domain.TraceInfo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

/**
 * 日志拦截器
 *
 * @Author: ByteExpress
 * @Date: 2023/12/24 10:10
 * @Version V1.0
 */
@Slf4j
public class LogInterceptor implements HandlerInterceptor {

    private static final ThreadLocal<TraceInfo> THREAD_LOCAL = new InheritableThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Log log = handlerMethod.getMethodAnnotation(Log.class);

        if (log != null) {
            TraceInfo traceInfo = new TraceInfo();
            traceInfo.setStart(System.currentTimeMillis());
            traceInfo.setRequestMethod(handlerMethod.getMethod().getName());
            traceInfo.setRequestUri(request.getRequestURI());

            String traceId = UUID.randomUUID().toString().replaceAll("-", "");
            traceInfo.setTraceId(traceId);

            MDC.put(TraceInfo.TRACE_ID, traceId);

            THREAD_LOCAL.set(traceInfo);
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Log logAnnotation = handlerMethod.getMethodAnnotation(Log.class);

        if (logAnnotation != null) {
            long end = System.currentTimeMillis();
            TraceInfo traceInfo = THREAD_LOCAL.get();
            long start = traceInfo.getStart();

            log.info("requestUri:{}, useTime:{} ms", traceInfo.getRequestUri(), end - start);
            THREAD_LOCAL.remove();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}