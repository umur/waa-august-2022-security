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

import java.util.List;
import java.util.stream.Collectors;

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
        List<String> list = (List<String>) joinPoint.proceed();
        list = list.stream().filter(item -> item.contains("spring"))
                .map(content -> {
                    content = content.replace("spring", "******");
                    return content;
                }).collect(Collectors.toList());
        WaaUserDetails userDetails = (WaaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Counter counter = new Counter(list.stream().filter(item -> item.contains("spring")).collect(Collectors.joining(", ")), userDetails.getId());
        repository.save(counter);
        return list;
    }
}
