package com.example.demo.service.productserviceimpl;


import com.example.demo.entity.products.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    @Override
    public Product create( Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update( Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById( String id) {
        return productRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Product not found"));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}
