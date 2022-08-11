package miu.edu.Assignment3.Controllers.BuisnessLogicController;


import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.UserDTO;
import miu.edu.Assignment3.Entities.BusinessLogicEntity.Review;
import miu.edu.Assignment3.Services.Interfaces.BusnissLogic.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<UserDTO> getAllUsers(){
        return userService.getAll();
    }

    @GetMapping("{id}")
    public UserDTO getUser(@PathVariable long id){
        return userService.getById(id);
    }

    @GetMapping("/{id}/reviews")
    public List<Review> getReviewsByUserId(@PathVariable long id){
        return userService.getById(id).getUserReviews();
    }

    @PostMapping()
    public void save (@RequestBody UserDTO userDTO){
        userService.save(userDTO);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable long id){
        userService.delete(id);
    }
    @PutMapping("{id}")
    public void update(@RequestBody UserDTO userDTO,@PathVariable long id){
        userService.update(userDTO,id);
    }
}
