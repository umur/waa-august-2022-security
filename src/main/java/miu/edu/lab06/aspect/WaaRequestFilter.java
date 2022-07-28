package miu.edu.lab06.aspect;

import lombok.RequiredArgsConstructor;
import miu.edu.lab06.model.Counter;
import miu.edu.lab06.repository.CounterRepository;
import miu.edu.lab06.security.WaaUserDetails;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaRequestFilter {

    private final CounterRepository repository;

    @Pointcut("within(miu.edu.lab06.controller..*)")
    public void annotated() {}
    @Before("annotated()")
    public void checkActivity(JoinPoint joinPoint) {
        WaaUserDetails userDetails = (WaaUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Instant now = Instant.now();
        Instant thirtyMinEarlier = now.minus(30, ChronoUnit.MINUTES);
        List<Counter> activities = repository.findAllByUserIdAndCreatedAtBetween(userDetails.getId(), thirtyMinEarlier, now);
        if (activities.size() > 5) {
            Instant lastActivityTime = activities.get(4).getCreatedAt();
            if (lastActivityTime.plus(15, ChronoUnit.MINUTES).isAfter(now))  {
                long waitMinutes = (lastActivityTime.plus(15, ChronoUnit.MINUTES).getEpochSecond() - now.getEpochSecond()) / 60;
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Max Bad Words Requests Limit has been Reached. You need wait for %o minutes.", waitMinutes));
            }
        }
    }
}
