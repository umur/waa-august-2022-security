package com.webshop.mapping.repository;

import com.webshop.mapping.domain.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAllByProductId(Long id);
}
