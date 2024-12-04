package com.example.shop.controller;

import com.example.shop.entity.ProductEntity;
import com.example.shop.service.CartService;
import com.example.shop.service.ProductService;
import com.example.shop.util.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestParam Long productId) {
        System.out.println("Tentativo di aggiungere il prodotto con ID: " + productId);
        ProductEntity product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Prodotto non trovato"));
        cartService.addProduct(product);
        System.out.println("Prodotto aggiunto al carrello: " + product.getId());
        return ResponseEntity.ok("Prodotto aggiunto al carrello");
    }


    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems() {
        return ResponseEntity.ok(cartService.getProducts());
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> removeFromCart(@RequestParam Long productId) {
        cartService.removeProduct(productId);
        return ResponseEntity.ok("Prodotto rimosso dal carrello");
    }
}
