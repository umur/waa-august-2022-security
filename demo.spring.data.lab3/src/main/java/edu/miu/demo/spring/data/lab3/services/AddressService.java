package edu.miu.demo.spring.data.lab3.services;

import edu.miu.demo.spring.data.lab3.dtos.AddressDto;

import java.util.List;

public interface AddressService {
    public List<AddressDto> getAll();
    public void save(AddressDto addressDto);
    public void delete(int id);
}
