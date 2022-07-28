package edu.miu.lab6.repo;

import edu.miu.lab6.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
    Role getByName(String name);
}
