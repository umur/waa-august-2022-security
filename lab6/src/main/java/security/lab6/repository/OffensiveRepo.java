package security.lab6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import security.lab6.entity.Offensive;
import security.lab6.entity.User;

import java.util.Date;
import java.util.List;

@Repository
public interface OffensiveRepo extends CrudRepository<Offensive, Integer> {
    List<Offensive> findByUserAndAndCreatedDateAfter(User user, Date date);
}
