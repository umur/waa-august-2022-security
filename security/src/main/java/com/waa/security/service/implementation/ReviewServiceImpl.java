package com.waa.security.service.implementation;

import com.waa.security.annotation.ExecutionTime;
import com.waa.security.dto.ReviewDto;
import com.waa.security.entity.Review;
import com.waa.security.repository.ReviewRepository;
import com.waa.security.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<ReviewDto> findAll() {
        return reviewRepository.findAll().stream().map(review -> reviewToDto(review)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public ReviewDto save(ReviewDto reviewDto) {
        return reviewToDto(reviewRepository.save(dtoToReview(reviewDto)));
    }
    @ExecutionTime
    @Override
    public ReviewDto findById(int reviewId) {
        return reviewToDto(reviewRepository.findById(reviewId).orElse(null));
    }
    @ExecutionTime
    @Override
    public ReviewDto update(ReviewDto reviewDto) {
        return reviewToDto(reviewRepository.save(dtoToReview(reviewDto)));
    }
    @ExecutionTime
    @Override
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDto reviewToDto(Review review) {
        return modelMapper.map(review, ReviewDto.class);
    }

    private Review dtoToReview(ReviewDto reviewDto) {
        return modelMapper.map(reviewDto, Review.class);
    }
}
