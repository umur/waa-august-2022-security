package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Integer> {

}
