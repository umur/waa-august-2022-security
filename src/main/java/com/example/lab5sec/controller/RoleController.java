package com.example.lab5sec.controller;

import com.example.lab5sec.entity.Role;
import com.example.lab5sec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping
    public void save(@RequestBody Role r) {
        roleService.create(r);
    }

    @GetMapping
    public List<Role> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable int id) {
        var product = roleService.getById(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        roleService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int roleId) {
        //call service
    }
}
