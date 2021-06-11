package com.example.demo.service;

import com.example.demo.entity.order.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order create(Order order);
    Order update(Order order);
    Order findById(String id);
    List<Order> findAll();
    public void deleteById(String id);
}
