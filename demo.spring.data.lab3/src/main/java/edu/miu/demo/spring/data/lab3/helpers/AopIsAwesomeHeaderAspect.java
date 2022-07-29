package edu.miu.demo.spring.data.lab3.helpers;
import edu.miu.demo.spring.data.lab3.exceptions.AOPIsAwesomeHeaderException;
import lombok.AllArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@AllArgsConstructor
@Aspect
@Component
public class AopIsAwesomeHeaderAspect {
    private final HttpServletRequest httpServletRequest;

    @Pointcut("@annotation(edu.miu.demo.spring.data.lab3.helpers.AopIsAwesomeHeader)")
    public void headerChecker() {
    }

    @Before("headerChecker()")
    public void execute(JoinPoint joinPoint) throws Throwable {
        if (httpServletRequest.getMethod().equals("POST") && httpServletRequest.getHeader("AOP-IS-AWESOME") == null) {
            throw new AOPIsAwesomeHeaderException("Header required");
        }
    }
}
