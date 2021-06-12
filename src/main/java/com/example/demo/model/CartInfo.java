package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartInfo {
    private int orderNumber;

    private CustomerInfo customerInfo;

    private final List<CartLineInfo> cartLines=new ArrayList<CartLineInfo>();

    private CartLineInfo findLineByCode(String code){
        for(CartLineInfo line:this.cartLines){
            if(line.getProductInfo().getCode().equals(code)){
                return line;
            }
        }
    return null;
    }

    public void addProduct(ProductInfo productInfo,int quatity){
        CartLineInfo line = this.findLineByCode(productInfo.getCode());

        if (line==null){
            line=new CartLineInfo();
            line.setQuantity(0);
            line.setProductInfo(productInfo);
            this.cartLines.add(line);
        }
        int newQuantity=line.getQuantity()+quatity;
    }
}
