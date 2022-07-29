package com.waa.lab.service;

import com.waa.lab.dto.ReviewDTO;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<ReviewDTO> findAll();

    Optional<ReviewDTO> findById(Integer id);

    void save(ReviewDTO reviewDTO);

    void deleteById(Integer id);

    List<ReviewDTO> findAllByProduct(Integer productId);
}
