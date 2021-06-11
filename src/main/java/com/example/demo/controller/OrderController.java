package com.example.demo.controller;

import com.example.demo.entity.order.Order;
import com.example.demo.service.orderserviceimpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @PostMapping
    public Order create(@RequestBody Order order){
       return orderService.create(order);
    }
}
