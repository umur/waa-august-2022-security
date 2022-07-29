package edu.miu.demo.spring.data.lab3.helpers;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RuntimeAspect {

    @Pointcut("@annotation(edu.miu.demo.spring.data.lab3.helpers.ExecutionTime)")
    public void runtime(){}

    @Around("runtime()")
    public Object calculate(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        // call the method
        Object result = proceedingJoinPoint.proceed(); // next
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        // return the result
        return result;
    }
}
