package miu.edu.Assignment3.AspectOP.ActivityLog;

import lombok.RequiredArgsConstructor;
import miu.edu.Assignment3.Entities.ActivitiesLog.ActivityLog;
import miu.edu.Assignment3.Repositories.ActivitiesLog.ActivitiesLogRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.Date;

@Aspect
@RequiredArgsConstructor
public class AspectClassForActivityLog {

    private ActivitiesLogRepository activitiesLogRepository;
    @Pointcut("@annotation(miu.edu.Assignment3.AspectOP.ActivityLog.ActivityLogger)")
    public void activityPointCut(){}

    @Around("activityPointCut()")
    public Object myMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long total = end - start;

        ActivityLog activityLog = new ActivityLog();
        activityLog.setLoginDate(new Date());
        activityLog.setDuration(total);
        activityLog.setOperation(proceedingJoinPoint.getSignature().getName());
        activitiesLogRepository.save(activityLog);

        return result;
    }
}
