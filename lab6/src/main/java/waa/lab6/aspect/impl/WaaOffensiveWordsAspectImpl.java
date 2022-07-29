package waa.lab6.aspect.impl;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import waa.lab6.entity.Review;
import waa.lab6.entity.User;
import waa.lab6.repository.UserRepo;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWordsAspectImpl {

    private final long expirationTime = 1 * 30 * 60 * 1000;
    private final UserRepo userRepo;
    private final String offensiveWord = "spring";

    @Pointcut("@annotation(waa.lab6.aspect.WaaOffensiveWords)")
    public void WaaOffensiveWords() {
    }

    //use in review
    @Before("WaaOffensiveWords()")
    public void checkOffensiveWords(JoinPoint joinPoint) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepo.findByEmail(userDetails.getUsername());
        Review review = (Review) joinPoint.getArgs()[0];
        if(review.getComment().contains(offensiveWord)){
            review.setComment(review.getComment().replaceAll(offensiveWord,"\\*\\*\\*\\*\\*\\*"));
            user.setCountSensitiveWords(user.getCountSensitiveWords() + 1);
            if(user.getCountSensitiveWords() == 5){
               long time =  System.currentTimeMillis() + expirationTime;
               user.setProhibitedTimestamp(Long.toString(time));
            }
        }
    }
}
