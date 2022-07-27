package miu.edu.lab06.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.lab06.model.Counter;
import miu.edu.lab06.repository.CounterRepository;
import miu.edu.lab06.security.WaaUserDetails;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {

    private final CounterRepository repository;

    @Pointcut("@annotation(WaaWord)")
    public void annotated() {}

    @Around("annotated()")
    public Object replaceOffensiveWord(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("annotated");
        String content = (String) joinPoint.proceed();
        if (content.contains("spring")) {
            content = content.replace("spring", "******");
            WaaUserDetails userDetails = (WaaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            repository.save(new Counter(content, userDetails.getId()));

        }
        return content;
    }
}
