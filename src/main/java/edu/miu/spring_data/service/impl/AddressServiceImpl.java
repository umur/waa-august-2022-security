package edu.miu.spring_data.service.impl;

import edu.miu.spring_data.dto.AddressDto;

import edu.miu.spring_data.entity.Address;

import edu.miu.spring_data.repository.AddressRepository;
import edu.miu.spring_data.service.AddressService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelmapper = new ModelMapper();

    @Override
    public List<AddressDto> findAll() {

        var addresses = addressRepository.findAll();
        var result = new ArrayList<AddressDto>();

        for(Address address : addresses)
        {
            AddressDto addressDto = new AddressDto();
            addressDto = modelmapper.map(address , AddressDto.class);
            result.add(addressDto);
        }
        return result;
    }

    @Override
    public AddressDto getAddress(int id) {
        Address address = addressRepository.findById(id).orElse(null);
        if(address != null)
        {
            AddressDto addressDto = modelmapper.map(address, AddressDto.class);
            return addressDto;
        }

        return null;
    }

    @Override
    public AddressDto addAddress(AddressDto addressDto) {
        Address address = modelmapper.map(addressDto , Address.class);
        Address a = addressRepository.save(address);
        AddressDto aa = modelmapper.map(a , AddressDto.class);
        return aa;
    }

    @Override
    public AddressDto updateAddress(AddressDto addressDto, int id) {
        Address address = addressRepository.findById(id).orElse(null);
        if(address != null)
        {
            Address a = modelmapper.map(addressDto , Address.class);
            Address aa = addressRepository.save(a);
            AddressDto adto = modelmapper.map(aa , AddressDto.class);
            return adto;
        }
        return null;
    }


    @Override
    public void deleteAddress(int id) {

        Address address = addressRepository.findById(id).orElse(null);
        if(address != null)
        {
            addressRepository.delete(address);
        }

    }
}
