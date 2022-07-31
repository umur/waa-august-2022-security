package com.example.lab5sec.service.impl;

import com.example.lab5sec.entity.User;
import com.example.lab5sec.repo.UserRepo;
import com.example.lab5sec.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
    @Override
    public User getById(Integer id) {
        return userRepo.findById(id).orElse(null);
    }
    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);
    }
    @Override
    public User create(User user) {
        return userRepo.save(user);
    }
}
