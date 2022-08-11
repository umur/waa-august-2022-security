package miu.edu.Assignment3.Services.Interfaces.ActivitiesLog;

import miu.edu.Assignment3.DTOs.ActivitiesLogDTO.ActivityLogDTO;
import miu.edu.Assignment3.Entities.ActivitiesLog.ActivityLog;

import java.util.List;

public interface ActivitiesLogService {

    public void save(ActivityLogDTO activityLogDTO);
    public void update(ActivityLogDTO activityLogDTO, long id);
    public List<ActivityLogDTO> getAll();
}
