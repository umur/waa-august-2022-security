package edu.miu.aspect;

import edu.miu.entity.Offense;
import edu.miu.entity.User;
import edu.miu.repository.OffenseRepository;
import edu.miu.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Aspect
@Component
public class WaaOffensiveWords {
    private static String OFFENSIVE_WORD = "spring";
    private final SecurityUtils securityUtils;
    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;
    private final OffenseRepository offenseRepository;

    @Pointcut("@annotation(edu.miu.aspect.OffensiveWordCount)")
    public void getPointCut() {
    }

    @Around("getPointCut()")
    public Object checkOffensiveWords(ProceedingJoinPoint point) throws Throwable {
        String productName = httpServletRequest.getParameter("name");
        User user = securityUtils.getCurrentUser();
        List<Offense> offenses = offenseRepository.findAllByUserAndCreatedDateAfterOrderByCreatedDateDesc(user, new Date(System.currentTimeMillis() - 1800000));
        if (offenses.size() >= 5) {
            httpServletResponse.setStatus(400);
            httpServletResponse.getWriter().write("Max Bad Words Requests Limit has been Reached. You need wait for 30 minutes.");
            return null;
        } else {
            if (!ObjectUtils.isEmpty(productName) && productName.contains(OFFENSIVE_WORD)) {
                System.out.println(user);
                offenseRepository.save(new Offense(productName.replace(OFFENSIVE_WORD, "******"), new Date(), user));
                httpServletResponse.setStatus(400);
                httpServletResponse.getWriter().write("Product name contains offensive word!");
                return null;
            }
        }
        return point.proceed();
    }
}
