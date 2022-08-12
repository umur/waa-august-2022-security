package edu.miu.spring_data.service;

import edu.miu.spring_data.dto.AddressDto;

import java.util.List;

public interface AddressService {

    List<AddressDto> findAll ();
    AddressDto getAddress(int id);
    AddressDto addAddress(AddressDto addressDto);
    AddressDto updateAddress(AddressDto addressDto , int id);
    void deleteAddress(int id);
}
