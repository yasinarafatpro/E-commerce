package com.example.demo.entity.address;


import com.example.demo.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@Service
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
