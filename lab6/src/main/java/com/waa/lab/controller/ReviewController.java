package com.waa.lab.controller;

import com.waa.lab.aop.WaaOffensiveWords;
import com.waa.lab.dto.ReviewDTO;
import com.waa.lab.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    List<ReviewDTO> findAll() {
        return reviewService.findAll();
    }

    @GetMapping("/{id}")
    Optional<ReviewDTO> findById(@PathVariable Integer id) {
        return reviewService.findById(id);
    }

    @WaaOffensiveWords(fieldNames = {"comment"})
    @PostMapping()
    void save(@RequestBody ReviewDTO reviewDTO) {
        reviewService.save(reviewDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody ReviewDTO reviewDTO) {
        reviewService.save(reviewDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        reviewService.deleteById(id);
    }

    @GetMapping("/findByProduct")
    List<ReviewDTO> findByProduct(@RequestParam Integer productId) {
        return reviewService.findAllByProduct(productId);
    }
}
