package cs545waa.lab6.repo;

import cs545waa.lab6.entity.Offense;
import cs545waa.lab6.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface OffenseRepo extends CrudRepository<Offense, Integer> {
    List<Offense> findByUserAndAndCreatedDateAfter(User user, Date date);
}
