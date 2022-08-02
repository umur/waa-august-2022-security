package edu.miu.lab5.repository;

import edu.miu.lab5.entity.BadWord;
import edu.miu.lab5.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadWordRepo extends CrudRepository<BadWord, Integer> {
    List<BadWord> findAllByUserId(int userId);
}
