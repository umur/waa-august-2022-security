package edu.miu.util;

import edu.miu.entity.User;
import edu.miu.jwt.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtils {
    public User getCurrentUser() {
        MyUserDetails customUser = null;
        User user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() != null) {
            customUser = (MyUserDetails) authentication.getPrincipal();
            if (customUser.getUser() != null) {
                user = customUser.getUser();
            }
        }
        return user;
    }
}
