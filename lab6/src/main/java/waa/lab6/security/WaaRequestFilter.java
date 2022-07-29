package waa.lab6.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import waa.lab6.entity.User;
import waa.lab6.repository.UserRepo;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class WaaRequestFilter extends OncePerRequestFilter {

    private final UserRepo userRepo;

    public WaaRequestFilter(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        User user = userRepo.findByEmail(userDetails.getUsername());
        if (user.getCountSensitiveWords() >= 5 && Long.parseLong(user.getProhibitedTimestamp()) > System.currentTimeMillis()) {
            long time = Long.parseLong(user.getProhibitedTimestamp()) - System.currentTimeMillis();
            response.getWriter().write("Max Bad Words Requests Limit has been Reached. You need wait for " + time / 1000 / 60 + " minutes.");
        } else {
            user.setCountSensitiveWords(0);
            user.setProhibitedTimestamp(null);
            userRepo.save(user);
            filterChain.doFilter(request, response);
        }
    }
}
