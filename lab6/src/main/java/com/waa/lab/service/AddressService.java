package com.waa.lab.service;

import com.waa.lab.dto.AddressDTO;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    List<AddressDTO> findAll();

    Optional<AddressDTO> findById(Integer id);

    void save(AddressDTO addressDTO);

    void deleteById(Integer id);
}
