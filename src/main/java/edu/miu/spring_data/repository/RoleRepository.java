package edu.miu.spring_data.repository;

import edu.miu.spring_data.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {
}
