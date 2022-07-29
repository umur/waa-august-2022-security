package cs545waa.lab6.aspect;

import cs545waa.lab6.entity.Offense;
import cs545waa.lab6.entity.User;
import cs545waa.lab6.model.ProductDto;
import cs545waa.lab6.repo.OffenseRepo;
import cs545waa.lab6.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class WaaOffensiveWords {
    private final String OFFENSE_WORD = "spring";
    private final int FREEZE_TIME = 1000 * 60 * 30; // 30 min
    private final HttpServletRequest httpServletRequest;
    private final HttpServletResponse httpServletResponse;
    private final UserRepo userRepo;
    private final OffenseRepo offenseRepo;

    @Pointcut("@annotation(cs545waa.lab6.aspect.OffensiveWordChecker)")
    public void offensive(){};

    @Around("offensive() && args(.., @RequestBody body)")
    public Object filterOffensive(ProceedingJoinPoint pjp, Object body) throws Throwable {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepo.findByUsername(username);
        List<Offense> offenses = offenseRepo.findByUserAndAndCreatedDateAfter(user, new Date(System.currentTimeMillis() - FREEZE_TIME));
        if (offenses.size() >= 5) {
            long diffMillis = FREEZE_TIME - new Date().getTime() + offenses.get(0).getCreatedDate().getTime();
            long diff = (diffMillis / (1000 * 60)) % 60;
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpServletResponse.getWriter().write("Too much swearing bro, chill down, try again after " + diff + " minutes...");
            return null;
        } else {
            ProductDto productDto = (ProductDto) body;
            String name = productDto.getName();
            if (name.contains(OFFENSE_WORD)) {
                offenseRepo.save(new Offense(0, name, new Date(), user));
                httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpServletResponse.getWriter().write("You have already sweared " + offenses.size() + " times, stop!");
                return null;
            }
        }
        return pjp.proceed();
    }
}
