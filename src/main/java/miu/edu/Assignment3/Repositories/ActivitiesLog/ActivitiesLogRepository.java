package miu.edu.Assignment3.Repositories.ActivitiesLog;

import miu.edu.Assignment3.Entities.ActivitiesLog.ActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivitiesLogRepository extends JpaRepository<ActivityLog, Long> {
}
