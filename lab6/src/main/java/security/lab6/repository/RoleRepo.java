package security.lab6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.lab6.entity.Role;

@Repository
public interface RoleRepo extends CrudRepository<Role, Integer> {
    Role getByRole(String name);
}