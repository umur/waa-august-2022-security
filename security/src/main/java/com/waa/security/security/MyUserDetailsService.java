package com.waa.security.security;

import com.waa.security.entity.User;
import com.waa.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(user==null){
            System.out.println("MyUserDetailsService loadUserByUsername");
            throw new UsernameNotFoundException("This username could not be found on database!");
        }
        return new MyUserDetails(user);
    }
}
