package com.example.lab5sec.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReqFilterAspect {
    @Before("execution(* com.example.lab5sec.service.*.*(..))")
    public void requestFilter (JoinPoint joinPoint) throws Exception {
    }

}
