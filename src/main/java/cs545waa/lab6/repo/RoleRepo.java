package cs545waa.lab6.repo;

import cs545waa.lab6.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
}
