package waa.lab6.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import waa.lab6.aspect.WaaOffensiveWords;
import waa.lab6.entity.Review;
import waa.lab6.repository.ReviewRepo;
import waa.lab6.service.ReviewService;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    @WaaOffensiveWords
    public void save(Review review) {
        reviewRepo.save(review);
    }
}
