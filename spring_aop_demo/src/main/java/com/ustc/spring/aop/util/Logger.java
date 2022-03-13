package com.ustc.spring.aop.util;

import com.ustc.spring.aop.annotaion.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class Logger {

    public void befor() {
        log.info("before...");
    }

    public void after() {
        log.info("after...");
    }

    @Around(value = "@annotation(com.ustc.spring.aop.annotaion.LogAnnotation)")
    public void logs(ProceedingJoinPoint joinPoint) {
        log.info("before...");
        LogAnnotation logAnnotation;
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        logAnnotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();


        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        log.info("after...");
    }
}
