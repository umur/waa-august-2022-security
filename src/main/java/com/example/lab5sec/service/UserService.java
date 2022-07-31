package com.example.lab5sec.service;

import com.example.lab5sec.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Integer id);

    void deleteById(Integer id);

    User create(User user);
}
