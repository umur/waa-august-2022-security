package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.ReviewDto;

import java.util.List;

public interface ReviewService {
    public List<ReviewDto> getAll();
    public void save(ReviewDto reviewDto);
    public void delete(int id);
}
