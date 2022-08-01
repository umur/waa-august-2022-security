package com.springsecurity.repository;

import com.springsecurity.domain.AppUser;
import com.springsecurity.domain.OffensiveWord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OffensiveWordRepository extends JpaRepository<OffensiveWord, Long> {
    List<OffensiveWord> findByAppUserAndCreatedAtAfter(AppUser appUser, Date date);
}
