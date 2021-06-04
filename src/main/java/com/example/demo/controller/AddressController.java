package com.example.demo.controller;

import com.example.demo.entity.address.Address;
import com.example.demo.service.addressservice.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/address")
public class AddressController {
    @Autowired
    AddressServiceImpl addressService;
    @PostMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Address> create(@RequestBody Address address){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(addressService.create(address));

    }
}
