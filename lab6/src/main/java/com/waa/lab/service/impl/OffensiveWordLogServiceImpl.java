package com.waa.lab.service.impl;

import com.waa.lab.dto.OffensiveWordLogDTO;
import com.waa.lab.entity.OffensiveWordLog;
import com.waa.lab.entity.User;
import com.waa.lab.repository.OffensiveWordLogRepository;
import com.waa.lab.service.OffensiveWordLogService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OffensiveWordLogServiceImpl implements OffensiveWordLogService {

    private final ModelMapper modelMapper;
    private final OffensiveWordLogRepository offensiveWordLogRepository;

    @Override
    public List<OffensiveWordLogDTO> findOffensiveWordLog(Integer userId, ZonedDateTime time) {
        var result = new ArrayList<OffensiveWordLogDTO>();
        offensiveWordLogRepository.findByUserIdAndTimeAfter(userId, time)
            .forEach(item -> {
                result.add(modelMapper.map(item, OffensiveWordLogDTO.class));
            });
        return result;
    }

    @Override
    public void logOffensiveWords(Integer userId, String word) {
        OffensiveWordLog offensiveWordLog = new OffensiveWordLog();
        User user = new User();
        user.setId(userId);
        offensiveWordLog.setUser(user);
        offensiveWordLog.setWord(word);
        offensiveWordLogRepository.save(offensiveWordLog);
    }
}
