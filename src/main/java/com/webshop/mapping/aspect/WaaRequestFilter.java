package com.webshop.mapping.aspect;


import com.webshop.mapping.exception.custom.VulnerableRequestException;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaRequestFilter {

    private final HttpServletRequest httpServletRequest;

    @Pointcut(value  ="execution(* com.webshop.mapping.controller..*(..))")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object logging(ProceedingJoinPoint jp) throws Throwable {
        if(!httpServletRequest.getRequestURI().contains("/profile")
                && httpServletRequest.getMethod().equals("POST")
                && httpServletRequest.getHeader("Authorization")!=null){
            String username = httpServletRequest.getUserPrincipal().getName();
            if(WaaOffensiveWord.userOffensiveCountMapper.getIfPresent(username)!=null
                    && WaaOffensiveWord.userOffensiveCountMapper.getIfPresent(username).getCount() >=3){
                UserOffensiveCount userOffensiveCount = WaaOffensiveWord.userOffensiveCountMapper.getIfPresent(username);
                if(userOffensiveCount.timeToWait()!=0){
                    throw new VulnerableRequestException(String.format("Max Bad Words Requests Limit has been Reached. You need wait for %s minutes.",userOffensiveCount.timeToWait()));
                }
            }
        }
        return jp.proceed();
    }

}
