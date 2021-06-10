package com.example.demo.controller;

import com.example.demo.entity.products.Product;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
public class HomeController {
    public String getProduct(@RequestBody Product product){
        return null;
    }
}
