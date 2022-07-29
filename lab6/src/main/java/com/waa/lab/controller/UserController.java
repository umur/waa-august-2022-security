package com.waa.lab.controller;

import com.waa.lab.dto.UserDTO;
import com.waa.lab.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    List<UserDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    Optional<UserDTO> findById(@PathVariable Integer id) {
        return userService.findById(id);
    }

    @PostMapping()
    void save(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
    }

}
