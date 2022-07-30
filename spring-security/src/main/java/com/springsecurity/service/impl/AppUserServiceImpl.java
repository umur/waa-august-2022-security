package com.springsecurity.service.impl;

import com.springsecurity.domain.AppUser;
import com.springsecurity.repository.AppUserRepository;
import com.springsecurity.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class AppUserServiceImpl implements AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Collection<AppUser> getAll() {
        return appUserRepository.findAll();
    }

    @Override
    public AppUser get(Long id) {
        return appUserRepository.findById(id).orElse(null);
    }

    @Override
    public AppUser save(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        return appUserRepository.save(appUser);
    }

    @Override
    public void delete(Long id) {
        appUserRepository.deleteById(id);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username).orElse(null);
    }
}
