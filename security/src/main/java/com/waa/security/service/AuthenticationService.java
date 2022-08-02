package com.waa.security.service;

import com.waa.security.dto.LoginRequest;

public interface AuthenticationService {

    String signin(LoginRequest loginRequest);
}
