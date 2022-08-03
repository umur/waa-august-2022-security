package miu.edu.springsecurity1.security;

//import miu.edu.springsecurity1.entity.User;
import miu.edu.springsecurity1.entity.MyUser;
import miu.edu.springsecurity1.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final JwtHelper jwtHelper;

    public MyUserDetailsService(UserRepository userRepository, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser user = userRepository.findByUsername(username);

        return new MyUserDetails(user);
    }


    public Optional<UserDetails> loadUserByJwtToken(String token) {
        if (jwtHelper.validateToken(token)) {
            return Optional.of(
                    User.withUsername(jwtHelper.getSubject(token))
                            .authorities(jwtHelper.getRoles(token))
                            .password("")
                            .accountExpired(false)
                            .accountLocked(false)
                            .credentialsExpired(false)
                            .disabled(false)
                            .build());
        }
        return Optional.empty();
    }

    public Optional<UserDetails> loadUserByJwtTokenAndDatabase(String jwtToken) {
        if (jwtHelper.validateToken(jwtToken)) {
            return Optional.of(loadUserByUsername(jwtHelper.getSubject(jwtToken)));
        } else {
            return Optional.empty();
        }
    }

}
