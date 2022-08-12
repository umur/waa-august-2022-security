package edu.miu.spring_data.service;

import edu.miu.spring_data.dto.ReviewDto;
import edu.miu.spring_data.entity.Review;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    ReviewDto getReview(int id);
    ReviewDto addReview(ReviewDto reviewDto);
    ReviewDto updateReview(ReviewDto reviewDto , int id);
    void deleteReview(int id);


}
