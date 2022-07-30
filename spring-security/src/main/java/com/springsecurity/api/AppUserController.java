package com.springsecurity.api;

import com.springsecurity.api.util.BasicControllerInterface;
import com.springsecurity.domain.AppUser;
import com.springsecurity.service.AppUserService;
import com.springsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class AppUserController implements BasicControllerInterface<AppUser, Long> {
    private final AppUserService appUserService;
    private final RoleService roleService;

    @Override
    @GetMapping
    public ResponseEntity<Collection<AppUser>> getAll() {
        return ResponseEntity.ok().body(appUserService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<AppUser> get(@PathVariable("id") Long id) {
        AppUser appUser = appUserService.get(id);
        if (appUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(appUser);
    }

    @Override
    @PostMapping
    public ResponseEntity<AppUser> save(@RequestBody AppUser appUser) {
        return ResponseEntity.ok().body(appUserService.save(appUser));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        appUserService.delete(id);
        return ResponseEntity.ok().build();
    }
}
