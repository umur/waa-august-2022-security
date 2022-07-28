package edu.miu.lab6.service.impl;

import edu.miu.lab6.entity.User;
import edu.miu.lab6.repo.UserRepo;
import edu.miu.lab6.service.UserService;
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
