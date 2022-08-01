package com.javokhir.lab6.repo;

import com.javokhir.lab6.domain.LocalUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<LocalUser, Long> {

    Optional<LocalUser> findFirstByUsername(String username);
}
