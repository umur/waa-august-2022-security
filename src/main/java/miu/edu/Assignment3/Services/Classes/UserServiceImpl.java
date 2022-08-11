package miu.edu.Assignment3.Services.Classes;

import miu.edu.Assignment3.DTOs.BuisnessLogicDTO.UserDTO;
import miu.edu.Assignment3.Exceptions.User;
import miu.edu.Assignment3.Exceptions.EmptyObjectException;
import miu.edu.Assignment3.Exceptions.ObjectExistException;
import miu.edu.Assignment3.Exceptions.UserNotFoundException;
import miu.edu.Assignment3.Repositories.BusinessLogicRepository.UserRepository;
import miu.edu.Assignment3.Services.Interfaces.BusnissLogic.UserService;
import miu.edu.Assignment3.UtilityClasses.Mapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public void save(UserDTO userDTO) {
        User userEntity = new User();
        userEntity = Mapper.ConvertDTOToUser(userDTO);
        userRepository.save(userEntity);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getById(Long id) {
        Optional<User> dataFromDatabase = userRepository.findById(id);
        if(dataFromDatabase.isEmpty()){
            throw new UserNotFoundException("User with this id = " + id +" is Not Found!!!");
        }
        UserDTO userDTO = new UserDTO();
        userDTO = Mapper.ConvertUserToDTO(dataFromDatabase.get());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        var UserDTOList = new ArrayList<UserDTO>();
        var dataFromDatabase = userRepository.findAll();
        if(dataFromDatabase.isEmpty()){
            throw new UserNotFoundException(" No Users To Show !!");
        }
        dataFromDatabase.forEach(user -> UserDTOList.add(Mapper.ConvertUserToDTO(user)));
        return UserDTOList;
    }

    @Override
    public void update(UserDTO userDTONewValue, long id) {
        User currentEntityValue = userRepository.findById(id).get();
        var newEntityValue = Mapper.ConvertDTOToUser(userDTONewValue);
        if(currentEntityValue.equals(newEntityValue)){
            throw new ObjectExistException("this Object is already Exist in data base");
        }
        if(newEntityValue.equals(null)){
            throw new EmptyObjectException("this object is Empty");
        }

        currentEntityValue.setFirstName(newEntityValue.getFirstName());
        currentEntityValue.setLastName(newEntityValue.getLastName());
        currentEntityValue.setPassword(newEntityValue.getPassword());
        currentEntityValue.setAddress(newEntityValue.getAddress());
        currentEntityValue.setUserName(newEntityValue.getUserName());
        currentEntityValue.setUserReviews(newEntityValue.getUserReviews());

         userRepository.save(currentEntityValue);
    }
}
