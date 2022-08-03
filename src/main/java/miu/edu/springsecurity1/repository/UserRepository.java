package miu.edu.springsecurity1.repository;

import miu.edu.springsecurity1.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {
    MyUser findByUsername(String username);
}
