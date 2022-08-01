package com.javokhir.lab6.sevice.auth;

import com.javokhir.lab6.domain.LocalUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface Security extends UserDetailsService {

    LocalUser getCurrentUser();
}
