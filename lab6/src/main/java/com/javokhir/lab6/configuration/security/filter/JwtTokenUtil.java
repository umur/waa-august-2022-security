package com.javokhir.lab6.configuration.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    public static final String AUTH_HEADER = "Authorization";
    public static final String AUTH_HEADER_PREFIX = "Bearer ";

    public static final long JWT_TOKEN_VALIDITY = 15 * 60;

    @Value("${security.jwt.secret}")
    private String secret;

    public String generateToken(UserDetails userDetails) {
        var claims = new HashMap<String, Object>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        final var username = getUserNameFromToken(token);
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final var claims = getClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getClaimsFromToken(String token) {
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }

    private boolean isTokenExpired(String token) {
        final var expirationDate = getClaimFromToken(token, Claims::getExpiration);
        return expirationDate.before(new Date());
    }
}
