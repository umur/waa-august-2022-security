package com.waa.lab.service;

import com.waa.lab.dto.OffensiveWordLogDTO;

import java.time.ZonedDateTime;
import java.util.List;

public interface OffensiveWordLogService {
    List<OffensiveWordLogDTO> findOffensiveWordLog(Integer userId, ZonedDateTime time);

    void logOffensiveWords(Integer userId, String word);
}
