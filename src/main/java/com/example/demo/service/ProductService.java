package com.example.demo.service;


import com.example.demo.entity.products.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product create(Product product);
    Product update(Product product);
    Product findById(String id);
    List<Product> findAll();
    void deleteById(String id);
}
