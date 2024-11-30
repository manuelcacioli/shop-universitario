package com.example.shop.service;

import com.example.shop.entity.ProductEntity;
import com.example.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProduct(){
        return productRepository.findAllWithExactPrecision();
    }
}
