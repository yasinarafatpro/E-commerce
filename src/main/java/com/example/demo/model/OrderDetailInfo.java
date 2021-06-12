package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailInfo {

    private String id;

    private String productCode;
    private String productName;

    private int quantity;
    private double price;
    private double amount;
}
