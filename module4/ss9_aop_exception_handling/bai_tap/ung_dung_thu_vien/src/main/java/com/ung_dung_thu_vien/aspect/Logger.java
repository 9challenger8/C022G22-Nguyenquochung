package com.ung_dung_thu_vien.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Logger {

    @AfterReturning(pointcut = " execution ( public * com.ung_dung_thu_vien.controller.BookController.*(..))")
    public void log(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        System.err.println("Chức năng vừa thực hiện xong: "+ name);
    }
}
