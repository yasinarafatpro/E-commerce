package com.example.demo.entity.products;


import com.example.demo.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Service
@Table(name = "Product")
public class Product{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2",strategy = "uuid2")
    private String code;
    private String name;
    private String productQuantity;
    private String price;
}
