package waa.lab6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import waa.lab6.entity.Review;

@Repository
public interface ReviewRepo extends CrudRepository<Review, Integer> {
}

