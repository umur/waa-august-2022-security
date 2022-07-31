package com.example.lab5sec.service.impl;

import com.example.lab5sec.entity.Role;
import com.example.lab5sec.repo.RoleRepo;
import com.example.lab5sec.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepo roleRepo;

    @Override
    public List<Role> getAll() {
        return (List<Role>) roleRepo.findAll();
    }

    @Override
    public Role getById(Integer id) {
        return roleRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        roleRepo.deleteById(id);
    }

    @Override
    public Role create(Role user) {
        return roleRepo.save(user);
    }
}
