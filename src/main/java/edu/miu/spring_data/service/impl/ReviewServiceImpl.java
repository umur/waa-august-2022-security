package edu.miu.spring_data.service.impl;

import edu.miu.spring_data.dto.ReviewDto;
import edu.miu.spring_data.entity.Review;
import edu.miu.spring_data.repository.ReviewRepository;
import edu.miu.spring_data.service.ReviewService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ModelMapper modelmapper = new ModelMapper();

    @Override
    public List<ReviewDto> findAll() {

        var reviews = reviewRepository.findAll();
        var result = new ArrayList<ReviewDto>();

        for(Review review : reviews)
        {
            ReviewDto reviewDto = new ReviewDto();
            reviewDto = modelmapper.map(review , ReviewDto.class);
            result.add(reviewDto);
        }
        return result;
    }

    @Override
    public ReviewDto getReview(int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null)
        {
            ReviewDto reviewDto = modelmapper.map(review , ReviewDto.class);
            return reviewDto;
        }

        return null;
    }

    @Override
    public ReviewDto addReview(ReviewDto reviewDto) {
        Review review = modelmapper.map(reviewDto , Review.class);
        Review r = reviewRepository.save(review);
        ReviewDto rr = modelmapper.map(r , ReviewDto.class);
        return rr;
    }

    @Override
    public ReviewDto updateReview(ReviewDto reviewDto, int id) {
        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null)
        {
            Review r = modelmapper.map(reviewDto , Review.class);
            Review rr = reviewRepository.save(r);
            ReviewDto rdto = modelmapper.map(rr , ReviewDto.class);
            return rdto;
        }
        return null;
    }


    @Override
    public void deleteReview(int id) {

        Review review = reviewRepository.findById(id).orElse(null);
        if(review != null)
        {
            reviewRepository.delete(review);
        }

    }


}
