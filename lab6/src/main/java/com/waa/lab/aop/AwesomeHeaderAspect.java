package com.waa.lab.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class AwesomeHeaderAspect {
    private static final String AWESOME_HEADER = "AOP-IS-AWESOME";
    @Pointcut("within(com.waa.lab.service..*)")
    public void checkHeaderPoint(){}

//    @Before("checkHeaderPoint()")
    public void checkAwesomeHeader(JoinPoint joinPoint) throws AopIsAwesomeHeaderException {
        String methodName = String.format( "%s.%s",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName());
        System.out.println("checkAwesomeHeader: " + methodName);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if(HttpMethod.POST.matches(request.getMethod())){
            if(request.getHeader(AWESOME_HEADER) == null){
                throw new AopIsAwesomeHeaderException();
            }
        }
    }
}
