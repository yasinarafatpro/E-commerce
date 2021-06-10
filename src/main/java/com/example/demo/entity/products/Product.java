package com.example.demo.entity.products;


import com.example.demo.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
@Table(name = "Product")
public class Product extends BaseEntity{
    private String productName;
    private String productQuantity;
    private String productPrice;
}
