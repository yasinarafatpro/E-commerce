package com.example.demo.entity.orderdetails;

import com.example.demo.entity.BaseEntity;
import com.example.demo.entity.order.Order;
import com.example.demo.entity.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order_Details")
public class OrderDetail extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID",foreignKey = @ForeignKey(name = "ORDER_DETAIL_ORD_FK"))
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID",foreignKey = @ForeignKey(name = "ORDER_DETAIL_PRO_FK"))
    private Product product;

    private int quantity;
    private double price;
    private double amount;
}
