package edu.miu.spring_data.controller;

import edu.miu.spring_data.dto.UserDto;
import edu.miu.spring_data.entity.Product;
import edu.miu.spring_data.entity.User;
import edu.miu.spring_data.repository.UserRepository;
import edu.miu.spring_data.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@CrossOrigin
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> findAll()
    {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id)
    {
        return userService.getUser(id);
    }

    @PostMapping
    public UserDto addUser(@RequestBody UserDto userDto )
    {
        return userService.addUser(userDto);
    }

    @PatchMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto userDto , @PathVariable int id)
    {
       return userService.updateUser(userDto , id);

    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id)
    {
        userService.removeUser(id);
    }


    @GetMapping("/{id}/products")
    public List<Product> findByUserId(@PathVariable int id){
        return userService.findByUserId(id);
    }



}
