package edu.miu.lab5.service;

import edu.miu.lab5.entity.BadWord;

import java.util.List;

public interface BadWordService {
    public void save(BadWord badWord);


    public List<BadWord> findBadWordsForLastThirtyMinutesByUserId(int userId);
}
