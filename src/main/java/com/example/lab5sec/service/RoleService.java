package com.example.lab5sec.service;

import com.example.lab5sec.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role getById(Integer id);

    void deleteById(Integer id);

    Role create(Role user);
}
