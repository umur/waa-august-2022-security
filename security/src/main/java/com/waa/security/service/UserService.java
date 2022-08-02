package com.waa.security.service;

import com.waa.security.dto.RegisterRequest;
import com.waa.security.entity.User;

public interface UserService {
    User findByUsername(String email);

    User signup(RegisterRequest registerRequest) throws Exception;
}
