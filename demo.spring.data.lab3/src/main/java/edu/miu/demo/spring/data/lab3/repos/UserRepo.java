package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
