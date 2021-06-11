package com.example.demo.controller;

import com.example.demo.entity.orderdetails.OrderDetail;
import com.example.demo.service.orderdetailserviceimpl.OrderDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/orderdetail")
public class OrderDetailController {
    @Autowired
    OrderDetailServiceImpl orderDetailService;

    @PostMapping
    public OrderDetail create(@RequestBody OrderDetail orderDetail){
        return orderDetailService.create(orderDetail);
    }
    @GetMapping
    public List<OrderDetail> findAll(@RequestBody OrderDetail orderDetail){
         return orderDetailService.findAll();
    }

}


