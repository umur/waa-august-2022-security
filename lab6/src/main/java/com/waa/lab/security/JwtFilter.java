package com.waa.lab.security;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final String AUTHORIZATION_HEADER = "Authorization";
    private final String BEARER_TOKEN = "Bearer ";
    private final JwtHelper jwtHelper;
    private final MyUserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader(AUTHORIZATION_HEADER);
        String email = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith(BEARER_TOKEN)) {
            token = authorizationHeader.substring(BEARER_TOKEN.length());
            try{
                email = jwtHelper.getEmailFromToken(token);
                buildSecurityContext(request, email);
            }catch (ExpiredJwtException e){
                String isRefreshToken = request.getHeader("isRefreshToken");
                //TODO: Refresh Token
                e.printStackTrace();
            }
        }
        filterChain.doFilter(request, response);
    }

    private void buildSecurityContext(HttpServletRequest request, String email) {
        if(!Strings.isEmpty(email) && SecurityContextHolder.getContext().getAuthentication() == null){
            var userDetails = userDetailsService.loadUserByUsername(email);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    userDetails, null, userDetails.getAuthorities());

            // TODO ????
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
