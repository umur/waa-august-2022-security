package edu.miu.springsecurity1.utils;

import edu.miu.springsecurity1.entity.UserProfanity;
import edu.miu.springsecurity1.exceptions.MaxProfanityWordsException;
import edu.miu.springsecurity1.security.AwesomeUserDetails;
import edu.miu.springsecurity1.service.ProfanityUserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Aspect
@Component
@RequiredArgsConstructor
public class ProfanityInterceptor {


    private final ProfanityUserService profanityUserService;

    @Pointcut("@annotation(edu.miu.springsecurity1.annotations.ProfanityFilter)")
    public void postMethods() {
    }

    ;

    @Around("postMethods() && args(.., body)")
    public Object filterProfanityText(ProceedingJoinPoint proceedingJoinPoint, Object body) throws Throwable {
        var userAuth = (AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String bodyAsString = body.toString();
        String profanityWords = ProfanityFilter.filterText(bodyAsString);

        if (profanityWords != null) {
            List<UserProfanity> userProfanities = profanityUserService.findProfanityForLastThirtyMins(userAuth.getId());
            if (userProfanities.size() >= 5) {
                throw new MaxProfanityWordsException("Max Bad Words Requests Limit has been Reached. You need wait for X minutes.");
            } else {
                UserProfanity userProfanity = new UserProfanity();
                userProfanity.setUserId(userAuth.getId());
                userProfanity.setCreatedDate(new Date());
                userProfanity.setWord(profanityWords);
                profanityUserService.save(userProfanity);
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
