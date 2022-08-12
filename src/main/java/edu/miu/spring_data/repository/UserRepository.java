package edu.miu.spring_data.repository;

import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.Review;
import edu.miu.spring_data.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query("SELECT p FROM User u  JOIN u.products p where u.id= ?1")
    List<Product> findByUserId(Integer id);

    User findByEmail(String email);


}
