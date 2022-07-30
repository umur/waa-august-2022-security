package com.springsecurity.service;

import com.springsecurity.domain.AppUser;

public interface AppUserService extends BasicServiceInterface<AppUser, Long> {
    AppUser findByUsername(String username);
}
