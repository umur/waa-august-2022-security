package miu.edu.Assignment3.AspectOP.BeforeAndAfter;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class AspectBeforeAndAfter {

    @Pointcut("execution(* miu.edu.Assignment3.Controllers.ActivityLogController.*.save(..))")
    public void saveSuccessPointCut(){}

    @Before("saveSuccessPointCut()")
    public void before(JoinPoint joinPoint){
        log.info("Before method save :: "+ joinPoint.getSignature());
    }

    @After("saveSuccessPointCut()")
    public void After(JoinPoint joinPoint){
        log.info("After method save :: "+ joinPoint.getSignature());
    }
}
