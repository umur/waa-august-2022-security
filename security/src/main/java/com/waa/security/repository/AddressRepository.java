package com.waa.security.repository;

import com.waa.security.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository  extends JpaRepository<Address,Integer> {
}
