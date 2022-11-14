package miu.edu.lab06.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import miu.edu.lab06.security.JwtHelper;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Log4j2
public class UaaServiceImpl implements UaaService {

    private final JwtHelper jwtHelper;
    private final AuthenticationManager manager;

    private final ModelMapper mapper;

    @Override
    public Map<String, String> login(Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        var request = new UsernamePasswordAuthenticationToken(username, password);
        final String accessToken = jwtHelper.generateToken(username);
        final String refreshToken = jwtHelper.generateRefreshToken(username);
        manager.authenticate(request);
        return Map.of("access_token", accessToken, "refresh_token", refreshToken);
    }

    @Override
    public Map<String, String> refresh(String oldToken) {
        boolean isRefreshTokenValid = jwtHelper.validateToken(oldToken);
        if (isRefreshTokenValid) {
            final String accessToken = jwtHelper.generateToken(jwtHelper.getSubject(oldToken));
            final String refreshToken = jwtHelper.generateRefreshToken(jwtHelper.getSubject(oldToken));
            return Map.of("access_token", accessToken, "refresh_token", refreshToken);
        }
        return new HashMap<>();
    }

    @Override
    public Map<String, Boolean> validate() {
        return new HashMap<>();
    }
}
