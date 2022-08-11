package miu.edu.Assignment3.Repositories.BusinessLogicRepository;

import miu.edu.Assignment3.Entities.BusinessLogicEntity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
