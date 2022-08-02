package com.example.demo.repository;

import com.example.demo.domain.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProductId(Long id);
}
