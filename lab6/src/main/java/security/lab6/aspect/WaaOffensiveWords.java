package security.lab6.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import security.lab6.dto.ProductDTO;
import security.lab6.entity.Offensive;
import security.lab6.entity.User;
import security.lab6.repository.OffensiveRepo;
import security.lab6.repository.UserRepo;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Aspect
@RequiredArgsConstructor
public class WaaOffensiveWords {
    private final String CustomOffWord = "spring";
    private final int timeout = 30 * 1000 * 60;
    private final HttpServletResponse httpServletResponse;
    private final UserRepo userRepo;
    private final OffensiveRepo offensiveRepo;

    @Pointcut("@annotation(security.lab6.aspect.IOffensive)")
    public void offensive(){};

    @Around("offensive()")
    public Object filter(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepo.findByEmail(username);
        List<Offensive> offenses = offensiveRepo.findByUserAndAndCreatedDateAfter(user, new Date(System.currentTimeMillis() - timeout));
        if (offenses.size() > 4) {
            long diffMillis = timeout - new Date().getTime() + offenses.get(0).getCreatedDate().getTime();
            long diff = (diffMillis / (1000 * 60)) % 60;
            throw new Exception("Blocked cuz bad for " + diff + " mins");
        }
        else {
            Object[] args = proceedingJoinPoint.getArgs();
            ProductDTO productDto = (ProductDTO)args[0];
            String name = productDto.getName();
            if (name.contains(CustomOffWord)) {
                offensiveRepo.save(new Offensive(0, name, new Date(), user));
                throw new Exception("Bad boy");
            }
        }
        return proceedingJoinPoint.proceed();
    }
}