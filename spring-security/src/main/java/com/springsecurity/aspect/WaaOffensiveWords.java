package com.springsecurity.aspect;

import com.springsecurity.domain.AppUser;
import com.springsecurity.domain.OffensiveWord;
import com.springsecurity.domain.Product;
import com.springsecurity.repository.AppUserRepository;
import com.springsecurity.repository.OffensiveWordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @Pointcut("@annotation(com.springsecurity.aspect.OffensiveWordFilter)")
    public void run() {
    }

    @Around("run() && args(.., @RequestBody body)")
    public Object checkOffensiveWords(ProceedingJoinPoint proceedingJoinPoint, Object body) throws Throwable {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        AppUser appUser = appUserRepository.findByUsername(username).get();
        Product product = (Product) body;
        List<OffensiveWord> words = offensiveWordRepository
                .findByAppUserAndCreatedAtAfter(appUser, new Date(System.currentTimeMillis() - ALLOWED_TIME_LIMIT));
        if (words.size() >= 5) {
            httpServletResponse.setStatus(400);
            httpServletResponse.getWriter().write("Requests Limit has been reached. You need wait for " + ALLOWED_TIME_LIMIT / 60000 + " minutes.");
            return null;
        } else {
            if (product.getName().contains(OFFENSIVE_WORD)) {
                offensiveWordRepository.save(new OffensiveWord(null, product.getName().replace(OFFENSIVE_WORD, "******"), new Date(), appUser));
                httpServletResponse.setStatus(400);
                httpServletResponse.getWriter().write("Offensive word!");
                return null;
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
