package miu.edu.Assignment3.Services.Classes.ActivitiesLog;

import lombok.RequiredArgsConstructor;
import miu.edu.Assignment3.AspectOP.ActivityLog.ActivityLogger;
import miu.edu.Assignment3.DTOs.ActivitiesLogDTO.ActivityLogDTO;
import miu.edu.Assignment3.Entities.ActivitiesLog.ActivityLog;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;
import miu.edu.Assignment3.Repositories.ActivitiesLog.ActivitiesLogRepository;
import miu.edu.Assignment3.Services.Interfaces.ActivitiesLog.ActivitiesLogService;
import miu.edu.Assignment3.UtilityClasses.Mapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivitiesLogService {

    private final ActivitiesLogRepository activitiesLogRepository;


    @Override
    public void save(ActivityLogDTO activityLogDTO) {
        ActivityLog activityLog = new ActivityLog();
        activityLog = Mapper.ConvertDTOToActivityLog(activityLogDTO);
        activitiesLogRepository.save(activityLog);
    }

    @Override
    public List<ActivityLogDTO> getAll() {
        List<ActivityLog> activityLogList = activitiesLogRepository.findAll();
        List<ActivityLogDTO> activityLogDTOList = activityLogList.stream().map(Entity -> Mapper.ConvertActivityLogToDTO(Entity)).collect(Collectors.toList());
        return activityLogDTOList;
    }


    @Override
    @ActivityLogger
    public void update(ActivityLogDTO activityLogDTO, long id) {
        ActivityLog currentEntityValue = activitiesLogRepository.findById(id).get();
        var newEntityValue = Mapper .ConvertDTOToActivityLog(activityLogDTO);
        currentEntityValue.setOperation(newEntityValue.getOperation());
        currentEntityValue.setDuration(newEntityValue.getDuration());
        currentEntityValue.setLoginDate(newEntityValue.getLoginDate());

        activitiesLogRepository.save(currentEntityValue);
    }
}
