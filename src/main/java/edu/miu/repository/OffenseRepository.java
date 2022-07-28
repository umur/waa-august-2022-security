package edu.miu.repository;

import edu.miu.entity.Offense;
import edu.miu.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OffenseRepository extends JpaRepository<Offense, Integer> {
    List<Offense> findAllByUserAndCreatedDateAfterOrderByCreatedDateDesc(User user, Date startDate);
}
