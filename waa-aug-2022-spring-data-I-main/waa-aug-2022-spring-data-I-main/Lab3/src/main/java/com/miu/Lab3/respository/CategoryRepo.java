package com.miu.Lab3.respository;

import com.miu.Lab3.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepo extends CrudRepository<Category,Integer> {

}
