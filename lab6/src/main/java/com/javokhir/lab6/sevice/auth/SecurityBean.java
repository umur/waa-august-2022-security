package com.javokhir.lab6.sevice.auth;

import com.javokhir.lab6.domain.LocalUser;
import com.javokhir.lab6.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.javokhir.lab6.exception.ErrorCode.USERNAME_NOT_FOUND;

@Component
@AllArgsConstructor
public class SecurityBean implements Security {

    private static LocalUser currentUser;

    private final UserRepo userRepo;

    @Override
    public LocalUser getCurrentUser() {

        if (currentUser != null) {
            return currentUser;
        }

        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) {
            throw new UsernameNotFoundException("Should be authenticated");
        }

        return loadUserByUsername(authentication.getName());
    }

    @Override
    public LocalUser loadUserByUsername(String username) throws UsernameNotFoundException {
        var localUser = getUserByUserName(username);
        if (localUser.isPresent()) {
            currentUser = localUser.get();
            return currentUser;
        } else {
            throw new UsernameNotFoundException(USERNAME_NOT_FOUND.name());
        }
    }

    private Optional<LocalUser> getUserByUserName(String username) {
        return userRepo.findFirstByUsername(username);
    }
}
