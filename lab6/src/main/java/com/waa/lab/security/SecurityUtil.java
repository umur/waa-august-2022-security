package com.waa.lab.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class SecurityUtil {

    public static MyUserDetails getCurrentUser(){
       return Optional.ofNullable(SecurityContextHolder.getContext())
                .map( context -> {
                    if(context.getAuthentication() instanceof UsernamePasswordAuthenticationToken authToken){
                        return authToken;
                    }else{
                        return null;
                    }
                })
                .map(authentication -> (MyUserDetails) authentication.getPrincipal())
                .orElse(null);
    }
}
