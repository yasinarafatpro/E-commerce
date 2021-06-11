package com.example.demo.service.orderdetailserviceimpl;

import com.example.demo.entity.orderdetails.OrderDetail;
import com.example.demo.repository.OrderDetailRepository;
import com.example.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail create(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail update(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail findById(String id) {
        return orderDetailRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Product details not found"));
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        orderDetailRepository.deleteById(id);
    }
}
