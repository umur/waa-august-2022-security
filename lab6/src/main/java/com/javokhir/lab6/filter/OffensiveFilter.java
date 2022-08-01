package com.javokhir.lab6.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javokhir.lab6.domain.LocalUser;
import com.javokhir.lab6.domain.OffensiveLog;
import com.javokhir.lab6.repo.OffensiveLogRepo;
import com.javokhir.lab6.sevice.auth.Security;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@Aspect
@Component
@AllArgsConstructor
public class OffensiveFilter {

    private final ObjectMapper objectMapper;
    private final Security security;
    private final OffensiveLogRepo offensiveLogRepo;

    @Pointcut("@annotation(com.javokhir.lab6.annotation.OffensiveValidation)")
    public void annotationPointCut() {
    }

    @SneakyThrows
    @Around("annotationPointCut()")
    public Object doOffensiveFilter(ProceedingJoinPoint joinPoint) {
        LocalUser user = security.getCurrentUser();
        Long count = offensiveLogRepo.getCountByUserIdInRequiredPeriod(user.getId());

        if (count > 5) {
            OffensiveLog last = offensiveLogRepo.getLastByUserId(user.getId());
            if (last != null) {
                throw new AccessDeniedException("Max Bad Words Requests Limit has been Reached. You need wait for 15 minutes.");
            }
        }

        boolean offensiveDetected = changeOffensive(joinPoint.getArgs());
        if (offensiveDetected) {
            offensiveLogRepo.save(new OffensiveLog(null, user, new Date()));
        }
        return joinPoint.proceed();
    }

    private boolean changeOffensive(Object... objects) throws IllegalAccessException {
        boolean offensiveDetected = false;
        for (Object o : objects) {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType().getSimpleName().equals(String.class.getSimpleName())) {
                    String val = (String) field.get(o);
                    if (val.toLowerCase().contains("spring")) {
                        val = val.toLowerCase().replace("spring", "******ing");
                        field.set(o, val);
                        offensiveDetected = true;
                    }
                }
            }
        }
        return offensiveDetected;
    }
}
