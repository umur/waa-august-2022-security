package edu.miu.spring_data.repository;

import edu.miu.spring_data.entity.Category;
import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(Double minPrice);
    //@Query("SELECT p FROM Product p JOIN p.category c where c.id = ?1 and  p.price = ?2")
    List<Product> findByCategoryIdAndPriceLessThan(Integer category_id , Double maxPrice);
    List<Product> findByNameContains(String keyword) ;

    @Query("SELECT r FROM Product p JOIN p.reviews r where p.id = ?1")
    List<Review> findAllReviewsOfProduct(Integer productId);
}
