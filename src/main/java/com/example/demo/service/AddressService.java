package com.example.demo.service;


import com.example.demo.entity.address.Address;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AddressService {
    Address  create(Address address);
    Address update(Address address);
    Address findById(String id);
    List<Address> findAll();
    public void delete(String id);
}
