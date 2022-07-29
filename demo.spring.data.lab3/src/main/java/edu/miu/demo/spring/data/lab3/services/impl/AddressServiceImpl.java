package edu.miu.demo.spring.data.lab3.services.impl;

import edu.miu.demo.spring.data.lab3.dtos.AddressDto;
import edu.miu.demo.spring.data.lab3.models.Address;
import edu.miu.demo.spring.data.lab3.repos.AddressRepo;
import edu.miu.demo.spring.data.lab3.services.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper modelMapper){
        this.addressRepo = addressRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AddressDto> getAll() {
        var allAddresses = addressRepo.findAll();
        var addresses = new ArrayList<AddressDto>();
        allAddresses.forEach(address -> addresses.add(modelMapper.map(address, AddressDto.class)));
        return addresses;
    }

    @Override
    public void save(AddressDto addressDto) {
        addressRepo.save(modelMapper.map(addressDto, Address.class));
    }

    @Override
    public void delete(int id) {
        addressRepo.deleteById(id);
    }
}
