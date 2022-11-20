package com.springsecurity.aspect;

import com.springsecurity.domain.AppUser;
import com.springsecurity.domain.OffensiveWord;
import com.springsecurity.domain.Product;
import com.springsecurity.repository.AppUserRepository;
import com.springsecurity.repository.OffensiveWordRepository;
import com.springsecurity.security.userdetails.MyUserDetails;
import com.springsecurity.security.userdetails.MyUserDetailsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class WaaOffensiveWords {
    private final String OFFENSIVE_WORD = "spring";
    private final long ALLOWED_TIME_LIMIT = 30 * 60 * 1000;
    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;

    private final AppUserRepository appUserRepository;
    private final OffensiveWordRepository offensiveWordRepository;
    private final MyUserDetailsService myUserDetailsService;

    @Pointcut("@annotation(com.springsecurity.aspect.OffensiveWordFilter)")
    public void run() {
    }

    @Around("run()")
    public Object checkOffensiveWords(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        AppUser appUser = appUserRepository.findByUsername(myUserDetailsService.getCurrentUser().getUsername()).get();
        int count = offensiveWordRepository.findByAppUserAndCreatedAtAfter(appUser, new Date(System.currentTimeMillis() - ALLOWED_TIME_LIMIT)).size();

        if (count > 5) {
            httpServletResponse.setStatus(400);
            httpServletResponse.getWriter().write("Requests Limit has been reached. You need wait for " + ALLOWED_TIME_LIMIT / 60000 + " minutes.");
            return null;
        }


        boolean offensiveDetected = changeOffensive(proceedingJoinPoint.getArgs());
        if (offensiveDetected) {
            offensiveWordRepository.save(new OffensiveWord(null, OFFENSIVE_WORD, new Date(), appUser));
        }

        return proceedingJoinPoint.proceed();
    }

    private boolean changeOffensive(Object... objects) throws IllegalAccessException {
        boolean offensiveDetected = false;
        for (Object o : objects) {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType().getSimpleName().equals(String.class.getSimpleName())) {
                    String val = (String) field.get(o);
                    if (val.toLowerCase().contains("spring")) {
                        val = val.toLowerCase().replace("spring", "***ing");
                        field.set(o, val);
                        offensiveDetected = true;
                    }
                }
            }
        }
        return offensiveDetected;
    }
}
