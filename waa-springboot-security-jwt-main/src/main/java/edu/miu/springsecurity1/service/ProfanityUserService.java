package edu.miu.springsecurity1.service;

import edu.miu.springsecurity1.entity.UserProfanity;

import java.util.List;

public interface ProfanityUserService {

    public void save(UserProfanity userProfanity);

    public UserProfanity findByUserId(int id);

    public List<UserProfanity> findProfanityForLastThirtyMins(int id);
}
