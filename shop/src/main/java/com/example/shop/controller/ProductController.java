package com.example.shop.controller;

import com.example.shop.entity.ProductEntity;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/api/")
public class ProductController {
    @Autowired
    private ProductService service;

//    @GetMapping("/list/product")
//    public ResponseEntity<List<ProductEntity>> getAllProducts() {
//        List<ProductEntity> products = service.getAllProduct();
//        return ResponseEntity.ok(products);
//
//    }

    @GetMapping("/home")
    public String showProducts(Model model) {
        List<ProductEntity> products = service.getAllProduct();
        for (int i = 0; i < products.size(); i++) {
            System.out.println("Prodotto n. " + i + ": " + products.get(i).toString());
        }
        model.addAttribute("products", products); // Passa la lista prodotti alla vista
        return "home"; // Nome del file HTML senza suffisso
    }

}
