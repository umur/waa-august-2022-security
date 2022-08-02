package edu.miu.lab5.util;

import edu.miu.lab5.anotation.BadWordFilter;
import edu.miu.lab5.entity.BadWord;
import edu.miu.lab5.exceptions.MaxBadWordExceptions;
import edu.miu.lab5.security.AwesomeUserDetails;
import edu.miu.lab5.service.BadWordService;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;
import java.util.List;

@Aspect
@RequiredArgsConstructor
public class BadWordFilterAspect {
    private final BadWordService badService;

    @Pointcut("@annotation(edu.miu.lab5.anotation.BadWordFilter)")
    public void a() {
    }

    ;

    @Around("a() && args(.., body)")
    public Object filterProfanityText(ProceedingJoinPoint proceedingJoinPoint, Object body) throws Throwable {
        var user = (AwesomeUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String bodyAsString = body.toString();
        String badWords = BadWordUtil.filterText(bodyAsString);

        if (badWords != null) {
            List<BadWord> userBadWords = badService.findBadWordsForLastThirtyMinutesByUserId(user.getId());
            if (userBadWords.size() >= 5) {
                throw new MaxBadWordExceptions("Max Bad Words Requests Limit has been Reached. You need to wait for 30 minutes.");
            } else {
                BadWord badWord = new BadWord();
                badWord.setUserId(user.getId());
                badWord.setCreatedDate(new Date());
                badWord.setWord(badWords);
                badService.save(badWord);
            }
        }
        return proceedingJoinPoint.proceed();
    }
}
