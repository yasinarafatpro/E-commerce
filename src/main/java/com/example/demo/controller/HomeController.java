package com.example.demo.controller;

import com.example.demo.entity.products.Product;
import com.example.demo.service.productserviceimpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/private/home")
public class HomeController {
    @Autowired
    ProductServiceImpl productService;

    @PostMapping
    public Product create(@RequestBody Product product){
        product.setCreateDate(new Date());
        product.setUpdateDate(new Date());
        return productService.create(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product){
        product.setUpdateDate(new Date());
        return productService.create(product);
    }

    @GetMapping("/id/{id}")
    public Product findById( String id){
        return productService.findById(id);
    }

    @GetMapping
    public List<Product> findAll(){
        return productService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Product> deleteById(@PathVariable String id){
        productService.findById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
