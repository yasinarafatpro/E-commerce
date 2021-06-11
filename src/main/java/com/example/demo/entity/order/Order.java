package com.example.demo.entity.order;

import com.example.demo.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "order_table")
public class Order extends BaseEntity {

    private Date orderDate;
    @Column(name = "Order_Number")
    private int orderNumber;
    @Column(name = "Order_amount")
    private double amount;
    @Column(name = "Customer_name",length = 225)
    private String name;
    @Column(name = "Customer_Address",length = 300)
    private String address;
    @Column(name = "Customer_email",length = 200)
    private String email;
    @Column(name = "Customer_Phone",length = 128)
    private String customerPhone;
}
