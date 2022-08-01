package com.javokhir.lab6.configuration.security.filter;

import com.javokhir.lab6.sevice.auth.Security;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.javokhir.lab6.configuration.security.filter.JwtTokenUtil.AUTH_HEADER;
import static com.javokhir.lab6.configuration.security.filter.JwtTokenUtil.AUTH_HEADER_PREFIX;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {

    private final Security security;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final var tokenHeader = request.getHeader(AUTH_HEADER);

        String userName = null;
        String jwtToken = null;

        if (tokenHeader != null && tokenHeader.startsWith(AUTH_HEADER_PREFIX)) {

            jwtToken = tokenHeader.substring(AUTH_HEADER_PREFIX.length());

            try {
                userName = jwtTokenUtil.getUserNameFromToken(jwtToken);
            } catch (Exception ignore) {
            }
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = security.loadUserByUsername(userName);

            if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
                var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
