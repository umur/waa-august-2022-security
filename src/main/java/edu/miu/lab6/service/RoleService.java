package edu.miu.lab6.service;

import edu.miu.lab6.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAll();

    Role getById(Integer id);

    void deleteById(Integer id);

    Role create(Role user);
}
