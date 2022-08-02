package edu.miu.lab5.service.impl;

import edu.miu.lab5.entity.BadWord;
import edu.miu.lab5.repository.BadWordRepo;
import edu.miu.lab5.service.BadWordService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordServiceImpl implements BadWordService {
    @Autowired
    private BadWordRepo badWordRepo;
    @Override
    public void save(BadWord badWord) {
        badWordRepo.save(badWord);
    }

    @Override
    public List<BadWord> findBadWordsForLastThirtyMinutesByUserId(int userId) {
        var badWords = badWordRepo.findAllByUserId(userId);
        LocalDateTime l = LocalDateTime.now().minus(Duration.of(30, ChronoUnit.MINUTES));
        Date date = Date.from(l.atZone(ZoneId.systemDefault()).toInstant());
        var userBadWords = badWords.stream().filter(b->b.getCreatedDate().after(date)).collect(Collectors.toList());
        return userBadWords;
    }
}
