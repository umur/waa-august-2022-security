package miu.edu.Assignment3.Controllers.ActivityLogController;

import lombok.RequiredArgsConstructor;
import miu.edu.Assignment3.AspectOP.ActivityLog.ActivityLogger;
import miu.edu.Assignment3.DTOs.ActivitiesLogDTO.ActivityLogDTO;
import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.UserDTO;
import miu.edu.Assignment3.Services.Interfaces.ActivitiesLog.ActivitiesLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/activities")
@RequiredArgsConstructor
public class ActivityLogController {

    private final ActivitiesLogService activitiesLogService;


    @GetMapping("/allActivities")
    public List<ActivityLogDTO> getAll(){
        return activitiesLogService.getAll();
    }

    @PostMapping()
    public void save(@RequestBody ActivityLogDTO activityLogDTO){
        activitiesLogService.save(activityLogDTO);
    }
    //@ActivityLogger
    @PutMapping("{id}")
    public void update(@RequestBody ActivityLogDTO activityLogDTO, @PathVariable long id){
        activitiesLogService.update(activityLogDTO,id);
    }
}
