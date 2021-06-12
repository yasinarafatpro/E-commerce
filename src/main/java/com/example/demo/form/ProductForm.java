package com.example.demo.form;

import com.example.demo.entity.products.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {
    private String code;
    private String name;
    private double price;

    private boolean newProduct=false;

    private MultipartFile dataFile;

//    public ProductForm() {
//        this.newProduct=true;
//    }

    public ProductForm(Product product) {
        this.code=product.getCode();
        this.code=product.getName();
        this.code=product.getPrice();
    }

}
