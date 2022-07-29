package com.waa.lab.controller;

import com.waa.lab.dto.AddressDTO;
import com.waa.lab.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    List<AddressDTO> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    Optional<AddressDTO> findById(@PathVariable Integer id) {
        return addressService.findById(id);
    }

    @PostMapping()
    void save(@RequestBody AddressDTO addressDTO) {
        addressService.save(addressDTO);
    }

    @PutMapping("/{id}")
    void update(@RequestBody AddressDTO addressDTO) {
        addressService.save(addressDTO);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Integer id) {
        addressService.deleteById(id);
    }

}
