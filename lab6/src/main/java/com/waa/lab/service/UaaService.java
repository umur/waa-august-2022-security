package com.waa.lab.service;

import com.waa.lab.entity.User;
import com.waa.lab.model.SigninRequest;
import com.waa.lab.model.SigninResponse;

public interface UaaService {
    SigninResponse signin(SigninRequest loginRequest);

    void signup(User user);
}
