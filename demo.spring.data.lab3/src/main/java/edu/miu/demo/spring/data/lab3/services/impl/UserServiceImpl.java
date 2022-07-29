package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.UserDto;
import edu.miu.demo.spring.data.lab3.models.User;
import edu.miu.demo.spring.data.lab3.repos.UserRepo;
import edu.miu.demo.spring.data.lab3.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo, ModelMapper modelMapper){
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<UserDto> getAll() {
        var users = userRepo.findAll();
        var newUserList = new ArrayList<UserDto>();
        users.forEach(user -> newUserList.add(modelMapper.map(user, UserDto.class)));
        return newUserList;
    }

    @Override
    public void save(UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
