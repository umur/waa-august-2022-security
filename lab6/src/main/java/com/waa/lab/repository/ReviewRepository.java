package com.waa.lab.repository;

import com.waa.lab.entity.Review;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {
    List<Review> findAllByProductId(Integer productId);
}
