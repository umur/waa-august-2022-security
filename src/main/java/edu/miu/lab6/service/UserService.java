package edu.miu.lab6.service;

import edu.miu.lab6.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Integer id);

    void deleteById(Integer id);

    User create(User user);
}
