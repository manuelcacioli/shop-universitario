package com.example.shop.service;

import com.example.shop.entity.ProductEntity;
import com.example.shop.util.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SessionScope
@Service
public class CartService {
    private final Map<Long, CartItem> cartItems = new HashMap<>();

    public void addProduct(ProductEntity product) {
        cartItems.compute(product.getId(), (id, existingItem) -> {
            if (existingItem == null) {
                return new CartItem(product, 1);
            }
            existingItem.incrementQuantity();
            return existingItem;
        });
    }

    public void removeProduct(Long productId) {
        CartItem item = cartItems.get(productId);
        if (item != null) {
            if (item.getQuantity() > 1) {
                item.decrementQuantity();
            } else {
                cartItems.remove(productId);
            }
        }
    }

    public List<CartItem> getProducts() {
        return new ArrayList<>(cartItems.values());
    }

    public BigDecimal calculateTotal() {
        return cartItems.values().stream()
                .map(item -> item.getProduct().getPrezzo().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
