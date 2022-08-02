package com.waa.security.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.waa.security.exception.ApiResponse;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@AllArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtHelper jwtHelper;
    private final ObjectMapper objectMapper;
    private final MyUserDetailsService myUserDetailsService;
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, javax.servlet.FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");
        String username = null;
        String token = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            try {
                username = jwtHelper.getUsernameFromToken(token);
            } catch (ExpiredJwtException e) {
                String isRefreshToken = request.getHeader("isRefreshToken");
                returnError(response, e);
                return;
            }
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                var userDetails = myUserDetailsService.loadUserByUsername(username);
                boolean isTokenValid = jwtHelper.validateToken(token);
                if (isTokenValid) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(

                            userDetails, null, userDetails.getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (UsernameNotFoundException e) {
                returnError(response, e);
                return;
            }

        }
        filterChain.doFilter(request, response);
    }
    private void returnError(HttpServletResponse response, Exception e) throws IOException {
        e.printStackTrace();
        ApiResponse<Object> apiResponse = new ApiResponse<>();
        apiResponse.setMessage(e.getMessage());
        apiResponse.setData(null);
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//                apiResponse.setTimestamp(LocalDateTime.now());
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(objectMapper.writeValueAsString(apiResponse));
    }
}
