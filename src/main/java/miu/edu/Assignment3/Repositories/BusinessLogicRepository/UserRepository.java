package miu.edu.Assignment3.Repositories.BusinessLogicRepository;

import miu.edu.Assignment3.Exceptions.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
