package edu.miu.demo.spring.data.lab3.Controllers;

import edu.miu.demo.spring.data.lab3.dtos.AddressDto;
import edu.miu.demo.spring.data.lab3.dtos.UserDto;
import edu.miu.demo.spring.data.lab3.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/address")
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> getAllAddresses(){
        return addressService.getAll();
    }

    @PostMapping
    public ResponseEntity addAddress(@RequestBody AddressDto addressDto){
        addressService.save(addressDto);
        return new ResponseEntity("Added address successfully", HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity deleteAddress(@RequestParam String id){
        addressService.delete(Integer.parseInt(id));
        return new ResponseEntity("Deleted address",HttpStatus.NO_CONTENT);
    }
}
