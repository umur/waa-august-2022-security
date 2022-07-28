package miu.edu.waaaugust2022security.repository;

import miu.edu.waaaugust2022security.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends CrudRepository<Product, Integer> {
}
