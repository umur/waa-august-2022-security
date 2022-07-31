package com.example.lab5sec.repo;

import com.example.lab5sec.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
    Role getByName(String name);
}
