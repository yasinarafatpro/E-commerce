package com.example.demo.controller;

import com.example.demo.entity.address.Address;
import com.example.demo.service.addressservice.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/private/address")
public class AddressController {
    @Autowired
    AddressServiceImpl addressService;

    @PostMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Address> create(@RequestBody Address address){
        address.setCreateDate(new Date());
        address.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(addressService.create(address));

    }

    @PutMapping
    @PreAuthorize("hasAuthority('customer:write')")
    public ResponseEntity<Address> update(@RequestBody Address address){
        address.setUpdateDate(new Date());
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(addressService.update(address));
    }

    @GetMapping("/id/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public ResponseEntity<Address> findById(@PathVariable String id ){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(addressService.findById(id));
    }
}
