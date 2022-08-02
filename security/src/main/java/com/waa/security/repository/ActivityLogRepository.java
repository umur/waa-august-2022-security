package com.waa.security.repository;

import com.waa.security.entity.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActivityLogRepository extends JpaRepository<ActivityLog, Integer> {
}
