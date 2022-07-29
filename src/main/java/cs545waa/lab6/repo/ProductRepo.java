package cs545waa.lab6.repo;

import cs545waa.lab6.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, Integer> {
}
