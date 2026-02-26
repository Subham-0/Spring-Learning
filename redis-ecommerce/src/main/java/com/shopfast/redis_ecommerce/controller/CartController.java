package com.shopfast.redis_ecommerce.controller;

import com.shopfast.redis_ecommerce.dto.CartItem;
import com.shopfast.redis_ecommerce.service.ShoppingCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
public class CartController {
    private final ShoppingCartService cartService;

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(
            @RequestHeader("User-Id") String userId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        cartService.addToCart(userId, productId, quantity);
        return ResponseEntity.ok("Product added to cart");
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getCart(@RequestHeader("User-Id") String userId) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getCartTotal(@RequestHeader("User-Id") String userId) {
        return ResponseEntity.ok(cartService.getCartTotal(userId));
    }

    @DeleteMapping("/remove/{productId}")
    public ResponseEntity<String> removeFromCart(
            @RequestHeader("User-Id") String userId,
            @PathVariable Long productId) {

        cartService.removeFromCart(userId, productId);
        return ResponseEntity.ok("Product removed from cart");
    }

    @DeleteMapping("/clear")
    public ResponseEntity<String> clearCart(@RequestHeader("User-Id") String userId) {
        cartService.clearCart(userId);
        return ResponseEntity.ok("Cart cleared");
    }
}
