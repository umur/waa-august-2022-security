package com.javokhir.lab6.repo;

import com.javokhir.lab6.domain.OffensiveLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffensiveLogRepo extends JpaRepository<OffensiveLog, Long> {

    @Query(value = "select count(id) from offensive_log o where o.user_id =:userId and o.detected_time >= now() - INTERVAL '30 minutes'", nativeQuery = true)
    Long getCountByUserIdInRequiredPeriod(Long userId);

    @Query(nativeQuery = true,value =
            "select * from offensive_log o where o.user_id =:userId and o.detected_time >= now() - INTERVAL  '15 minutes' order by id desc limit 1")
    OffensiveLog getLastByUserId(Long userId);
}
