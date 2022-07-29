package com.waa.lab.aop;

import com.waa.lab.dto.ActivityLogDTO;
import com.waa.lab.service.ActivityLogService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityLogService activityLogService;
    @Pointcut("@annotation(com.waa.lab.aop.ExecutionTime)")
    public void executionTimeAnno(){}

    @Pointcut("within(com.waa.lab.controller.*)")
    public void allController(){}

    @Around("executionTimeAnno() || allController()")
    public Object getExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        String methodName = String.format( "%s.%s",
                proceedingJoinPoint.getSignature().getDeclaringTypeName(),
                proceedingJoinPoint.getSignature().getName());
        logExecutionTime(methodName, executionTime);
        return result;
    }

    @Async()
    public void logExecutionTime(String methodName, long executionTime){
        ActivityLogDTO activityLogDTO = new ActivityLogDTO();
        activityLogDTO.setOperation(methodName);
        activityLogDTO.setDuration(executionTime);
        activityLogService.save(activityLogDTO);
    }

}
