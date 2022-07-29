package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.ReviewDto;
import edu.miu.demo.spring.data.lab3.models.Review;
import edu.miu.demo.spring.data.lab3.repos.ReviewRepo;
import edu.miu.demo.spring.data.lab3.services.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    private final ModelMapper modelMapper;

    public ReviewServiceImpl(ReviewRepo reviewRepo, ModelMapper modelMapper){
        this.reviewRepo = reviewRepo;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ReviewDto> getAll() {
        var allReviews = reviewRepo.findAll();
        var reviews = new ArrayList<ReviewDto>();
        allReviews.forEach(review -> reviews.add(modelMapper.map(review, ReviewDto.class)));
        return reviews;
    }

    @Override
    public void save(ReviewDto reviewDto) {
        reviewRepo.save(modelMapper.map(reviewDto, Review.class));
    }

    @Override
    public void delete(int id) {
        reviewRepo.deleteById(id);
    }
}
