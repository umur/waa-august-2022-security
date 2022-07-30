package edu.miu.springsecurity1.service.impl;

import edu.miu.springsecurity1.entity.UserProfanity;
import edu.miu.springsecurity1.repository.ProfanityUserRepo;
import edu.miu.springsecurity1.service.ProfanityUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProfanityUserServiceImpl implements ProfanityUserService {

    private final ProfanityUserRepo profanityUserRepo;

    @Override
    public void save(UserProfanity userProfanity) {
        profanityUserRepo.save(userProfanity);
    }

    @Override
    public UserProfanity findByUserId(int id) {
        return null;
    }

    @Override
    public List<UserProfanity> findProfanityForLastThirtyMins(int id) {
        return profanityUserRepo.findProfanityForLastThirtyMins(id);
    }
}
