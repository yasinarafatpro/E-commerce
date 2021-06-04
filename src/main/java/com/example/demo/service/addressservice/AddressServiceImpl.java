package com.example.demo.service.addressservice;

import com.example.demo.entity.address.Address;
import com.example.demo.repository.AddressRepository;
import com.example.demo.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressRepository addressRepository;
    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address findById(String id) {
        return addressRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("User Not found by address"));
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(String id) {
         addressRepository.deleteById(id);
    }
}
