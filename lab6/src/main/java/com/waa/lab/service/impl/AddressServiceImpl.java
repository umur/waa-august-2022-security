package com.waa.lab.service.impl;

import com.waa.lab.dto.AddressDTO;
import com.waa.lab.entity.Address;
import com.waa.lab.repository.AddressRepository;
import com.waa.lab.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final ModelMapper modelMapper;
    private final AddressRepository addressRepository;

    @Override
    public List<AddressDTO> findAll() {
        var result = new ArrayList<AddressDTO>();
        addressRepository.findAll().forEach(item -> {
            result.add(modelMapper.map(item, AddressDTO.class));
        });
        return result;
    }

    @Override
    public Optional<AddressDTO> findById(Integer id) {
        return addressRepository.findById(id).map(item -> modelMapper.map(item, AddressDTO.class));
    }

    @Override
    public void save(AddressDTO addressDTO) {
        addressRepository.save(modelMapper.map(addressDTO, Address.class));
    }

    @Override
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }
}
