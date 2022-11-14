package miu.edu.lab06.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.lab06.service.UaaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@RestController
@RequestMapping("api/uaa")
@RequiredArgsConstructor
@CrossOrigin
public class UaaController {

    private final UaaServiceImpl service;

    @PostMapping("signin")
    public Map<String, String> signIn(@RequestBody Map<String, String> body) {
        return service.login(body);
    }

    @PostMapping("refresh")
    public Map<String, String> refresh(@RequestBody Map<String, String> body) {
        String refreshToken = body.get("refresh_token");
        return service.refresh(refreshToken);
    }

    @GetMapping("validate")
    public Map<String, Boolean> validate() {
        return service.validate();
    }

    @DeleteMapping("signout")
    public void signOut(Principal principal) {

    }
}
