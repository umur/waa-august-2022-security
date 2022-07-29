package edu.miu.demo.spring.data.lab3.repos;

import edu.miu.demo.spring.data.lab3.models.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepo extends CrudRepository<Address, Integer> {
}
