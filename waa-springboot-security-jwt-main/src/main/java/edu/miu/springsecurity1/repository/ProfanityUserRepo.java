package edu.miu.springsecurity1.repository;

import edu.miu.springsecurity1.entity.UserProfanity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfanityUserRepo extends CrudRepository<UserProfanity, Integer> {
    public UserProfanity findByUserId(int userId);

    @Query(value = "SELECT * FROM user_profanity u where u.created_date > (NOW() - INTERVAL '+30 minutes')", nativeQuery = true)
    public List<UserProfanity> findProfanityForLastThirtyMins(int userId);
}
