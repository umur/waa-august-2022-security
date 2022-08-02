package com.waa.security.service;


import com.waa.security.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();
    ReviewDto save(ReviewDto reviewDto);
    ReviewDto findById(int reviewDto);
    ReviewDto update(ReviewDto reviewDto);
    void delete(int id);
}
