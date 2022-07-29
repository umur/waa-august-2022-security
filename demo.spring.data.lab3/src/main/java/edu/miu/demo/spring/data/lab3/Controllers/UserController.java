package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.UserDto;
import edu.miu.demo.spring.data.lab3.models.User;
import edu.miu.demo.spring.data.lab3.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        userService.save(userDto);
        return new ResponseEntity("Added user successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity updateUser(@RequestParam String id){
        userService.delete(Integer.parseInt(id));
        return new ResponseEntity("Deleted user",HttpStatus.NO_CONTENT);
    }
}
