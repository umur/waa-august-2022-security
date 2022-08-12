package edu.miu.spring_data.controller;

import edu.miu.spring_data.dto.AddressDto;
import edu.miu.spring_data.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
@AllArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public List<AddressDto> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public AddressDto getAddressById(@PathVariable int id) {
        return addressService.getAddress(id);
    }

    @PostMapping
    public AddressDto addAddress(@RequestBody AddressDto addressDto) {
        return addressService.addAddress(addressDto);
    }

    @PutMapping("/{id}")
    public AddressDto updateAddress(@RequestBody AddressDto addressDto, @PathVariable int id) {
        return addressService.updateAddress(addressDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable int id) {
        addressService.deleteAddress(id);
    }
}
