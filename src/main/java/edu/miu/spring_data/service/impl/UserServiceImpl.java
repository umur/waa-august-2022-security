package edu.miu.spring_data.service.impl;

import edu.miu.spring_data.entity.Role;
import edu.miu.spring_data.model.SignUpDto;
import edu.miu.spring_data.dto.UserDto;
import edu.miu.spring_data.entity.Address;
import edu.miu.spring_data.entity.Product;

import edu.miu.spring_data.entity.User;
import edu.miu.spring_data.repository.AddressRepository;
import edu.miu.spring_data.repository.UserRepository;
import edu.miu.spring_data.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository ;
    private final AddressRepository addressRepository;
    private final ModelMapper modelmapper = new ModelMapper();
    private final PasswordEncoder passwordEncoder;


    @Override
    public List<UserDto> findAll() {
        var users = userRepository.findAll();
        var result = new ArrayList<UserDto>();

        for(User user : users)
        {
            UserDto dto = new UserDto();
            dto = modelmapper.map(user , UserDto.class);
            result.add(dto);
        }
        return result;
    }

    @Override
    public User getUser(int id) {
        User user = userRepository.findById(id).orElse(null);
//        if(user != null)
//        {
//            UserDto dto = modelmapper.map(user , UserDto.class);
//            return dto;
//        }
       return user;
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        int address_id = userDto.getAddressId();

        Address addr = addressRepository.findById(address_id).orElse(null);
        User user = modelmapper.map(userDto, User.class);
        user.setAddress(addr);
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User s = userRepository.save(user);
        UserDto u = modelmapper.map(s, UserDto.class);
        return u;
    }

    @Override
    public UserDto updateUser(UserDto userDto , int id) {
        User user = userRepository.findById(id).orElse(null);
        if(user != null)
        {
            User user1 = modelmapper.map(userDto , User.class);
            User s = userRepository.save(user1);
            UserDto u = modelmapper.map(s , UserDto.class);
            return u;
        }

       return null;
    }

    @Override
    public void removeUser(int id) {
        User user = userRepository.findById(id).orElse(null);
        System.out.println("Deleting a data.");
        if(user != null)
        { userRepository.delete(user); }

    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    @Override
    public SignUpDto addSignUpUser(SignUpDto signUpDto) {
        int address_id = signUpDto.getAddressId();

        Address addr = addressRepository.findById(address_id).orElse(null);
        User user = new User();
        user.setFirstname(signUpDto.getFirstname());
        user.setLastname(signUpDto.getLastname());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user.setEmail(signUpDto.getEmail());
        user.setAddress(addr);
        user.setRoles(Arrays.asList(new Role("ADMIN")));

        userRepository.save(user);

        return signUpDto;
    }

    @Override
    public List<Product> findByUserId(Integer id) {
        return userRepository.findByUserId(id);
    }

//    @Override
//    public List<Review> findAllReviewsOfProduct(Integer productId) {
//        return userRepository.findAllReviewsOfProduct(productId);
//    }
}
