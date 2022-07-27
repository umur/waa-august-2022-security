package miu.edu.lab06.service;

import java.util.Map;

public interface UaaService {
    Map<String, String> login(Map<String, String> body);

    Map<String, String> refresh(String token);
    Map<String, Boolean> validate();
}
