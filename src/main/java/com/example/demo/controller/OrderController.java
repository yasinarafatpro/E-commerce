package com.example.demo.controller;

import com.example.demo.entity.order.Order;
import com.example.demo.service.orderserviceimpl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/private/order")
public class OrderController {
    @Autowired
    OrderServiceImpl orderService;
    @PostMapping
    public Order create(@RequestBody Order order){
        order.setCreateDate(new Date());
        order.setUpdateDate(new Date());
       return orderService.create(order);
    }
    public List<Order> findAll(@RequestBody Order order){
        return orderService.findAll();
    }
}
