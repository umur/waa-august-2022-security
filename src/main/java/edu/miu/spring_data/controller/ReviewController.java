package edu.miu.spring_data.controller;

import edu.miu.spring_data.dto.ReviewDto;

import edu.miu.spring_data.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/v1/reviews")

public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public List<ReviewDto> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto getReviewById(@PathVariable int id) {
        return reviewService.getReview(id);
    }

    @PostMapping
    public ReviewDto addReview(@RequestBody ReviewDto reviewDto) {
        return reviewService.addReview(reviewDto);
    }

    @PutMapping("/{id}")
    public ReviewDto updateReview(@RequestBody ReviewDto reviewDto, @PathVariable int id) {
        return reviewService.updateReview(reviewDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }

}


