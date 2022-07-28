package edu.miu.lab6.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReqFilterAspect {
    @Before("execution(* edu.miu.lab6.service.*.*(..))")
    public void requestFilter (JoinPoint joinPoint) throws Exception {
    }

}
