package waa.lab6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab6.entity.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
