package com.waa.lab.service;

import com.waa.lab.dto.ActivityLogDTO;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {
    List<ActivityLogDTO> findAll();

    Optional<ActivityLogDTO> findById(Integer id);

    void save(ActivityLogDTO activityLogDTO);

    void deleteById(Integer id);
}
