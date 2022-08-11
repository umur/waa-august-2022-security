package miu.edu.Assignment3.Repositories.BusinessLogicRepository;

import miu.edu.Assignment3.Entities.BusinessLogicEntity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
