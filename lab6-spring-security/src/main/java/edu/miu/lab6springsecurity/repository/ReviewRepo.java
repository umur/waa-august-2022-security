package edu.miu.lab6springsecurity.repository;

import edu.miu.lab6springsecurity.entity.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewRepo extends CrudRepository<Review, Integer> {
}
