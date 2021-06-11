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
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {
    @Column(name = "country")
    private String country;
    @Column(name = "division_name")
    private String division;
    @Column(name = "zila_name")
    private String zila;
    @Column(name = "thana_name")
    private String thana;
    @Column(name = "postal_Code")
    private String postal_Code;
    @Column(name = "village_name")
    private String village;
    @Column(name="address_type")
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
}
