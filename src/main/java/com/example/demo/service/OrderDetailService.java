package com.example.demo.service;

import com.example.demo.entity.orderdetails.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail create(OrderDetail orderDetail);
    OrderDetail update(OrderDetail orderDetail);
    OrderDetail findById(String id);
    List<OrderDetail> findAll();
    void deleteById(String id);
}
