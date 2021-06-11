package com.example.demo.controller;

import com.example.demo.entity.products.Product;
import com.example.demo.service.productserviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/private/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productService;

    @PostMapping
    public Product create(@RequestBody Product product){
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        return productService.create(product);
    }

    @GetMapping
    public List<Product> product(@RequestBody Product product){
        return productService.findAll();
    }
}
