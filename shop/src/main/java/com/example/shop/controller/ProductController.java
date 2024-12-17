package com.example.shop.controller;

import com.example.shop.entity.ProductEntity;
import com.example.shop.service.CartService;
import com.example.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService service;
    @Autowired
    private CartService cartService;

//    @GetMapping("/list/product")
//    public ResponseEntity<List<ProductEntity>> getAllProducts() {
//        List<ProductEntity> products = service.getAllProduct();
//        return ResponseEntity.ok(products);
//
//    }

    @GetMapping("/home")
    public String showProducts(Model model) {
        List<ProductEntity> products = service.getAllProduct();
        model.addAttribute("products", products); // Passa la lista prodotti alla vista
        return "home"; // Nome del file HTML senza suffisso
    }

    @GetMapping("/")
    public String home(Model model) {
        List<ProductEntity> products = service.getAllProduct();
        model.addAttribute("products", products); // Passa la lista prodotti alla vista
        return "home"; // Nome del file HTML senza suffisso
    }

    @GetMapping("/products/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        Optional<ProductEntity> product = service.getProductById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-details"; // Nome del template
        } else {
            return "error-page"; // Template di errore nel caso il prodotto non esista
        }
    }
}
