package com.waa.security.service.implementation;

import com.waa.security.annotation.ExecutionTime;
import com.waa.security.dto.AddressDto;
import com.waa.security.entity.Address;
import com.waa.security.repository.AddressRepository;
import com.waa.security.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @ExecutionTime
    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll().stream().map(address -> addressToDto(address)).collect(Collectors.toList());
    }
    @ExecutionTime
    @Override
    public AddressDto save(AddressDto addressDto) {
        return addressToDto(addressRepository.save(dtoToAddress(addressDto)));
    }
    @ExecutionTime
    @Override
    public AddressDto findById(int addressId) {
        return addressToDto(addressRepository.findById(addressId).orElse(null));
    }
    @ExecutionTime
    @Override
    public AddressDto update(AddressDto addressDto) {
        return addressToDto(addressRepository.save(dtoToAddress(addressDto)));
    }
    @ExecutionTime
    @Override
    public void delete(int id) {
        addressRepository.deleteById(id);
    }

    private AddressDto addressToDto(Address address) {
        return modelMapper.map(address, AddressDto.class);
    }

    private Address dtoToAddress(AddressDto addressDto) {
        return modelMapper.map(addressDto, Address.class);
    }
}
