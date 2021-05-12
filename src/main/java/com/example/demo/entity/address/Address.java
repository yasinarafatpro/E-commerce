package com.example.demo.entity.address;


import com.example.demo.entity.BaseEntity;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Address extends BaseEntity {
    @Column(name = "country")
    private String country;
    private String division;
    private String zila;
    private String thana;
    private String postal_Code;
    private String village;
    @Column(name="address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
