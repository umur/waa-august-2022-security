package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.ReviewDto;
import edu.miu.demo.spring.data.lab3.services.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@AllArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping
    public List<ReviewDto> getAllReviews(){
        return reviewService.getAll();
    }

    @PostMapping
    public ResponseEntity addReview(@RequestBody ReviewDto reviewDto){
        reviewService.save(reviewDto);
        return new ResponseEntity("Added review successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity updateReview(@RequestParam String id){
        reviewService.delete(Integer.parseInt(id));
        return new ResponseEntity("Deleted review",HttpStatus.NO_CONTENT);
    }
}
