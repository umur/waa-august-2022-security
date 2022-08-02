package com.waa.security.security;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtHelper {
    @Value("${jwt.secret}")
    private String SECRET;
    private final long expiration = 15 *  60 * 1000;

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + expiration)).signWith(SignatureAlgorithm.HS512, SECRET).compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            System.out.println("validateToken");
            e.printStackTrace();
        }
        return false;
    }

    public String getUsernameFromToken(String token) {
        String result = "";
        try {
            result = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody().getSubject();
        } catch (ExpiredJwtException e) {
            System.out.println(e.getMessage());
            throw e;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
        return result;
    }
}
