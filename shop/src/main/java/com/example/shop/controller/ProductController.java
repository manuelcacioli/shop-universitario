package com.example.shop.controller;

import com.example.shop.entity.ProductEntity;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/list/product")
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        List<ProductEntity> products = service.getAllProduct();
        return ResponseEntity.ok(products);
    }

}
