package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.models.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Integer> {
}
