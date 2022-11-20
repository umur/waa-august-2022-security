package com.springsecurity.security.userdetails;

import com.springsecurity.domain.AppUser;
import com.springsecurity.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final AppUserRepository appUserRepository;

    public UserDetails getCurrentUser() throws UsernameNotFoundException{
        var auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null){
            throw new UsernameNotFoundException("Login required");
        }
        return loadUserByUsername(auth.getName());
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUser = appUserRepository.findByUsername(username);
        if (appUser.isEmpty()) {
            throw new UsernameNotFoundException("Username not found in database");
        }
        return new MyUserDetails(appUser.get());
    }
}
