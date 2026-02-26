package com.shopfast.redis_ecommerce.service;

import com.shopfast.redis_ecommerce.dto.CartItem;
import com.shopfast.redis_ecommerce.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShoppingCartService {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ProductService productService;

    private static final String CART_PREFIX = "cart:";
    private static final long CART_EXPIRY_HOURS = 24;

    public void addToCart(String userId, Long productId, Integer quantity) {
        String cartKey = CART_PREFIX + userId;
        HashOperations<String, String, CartItem> hashOps = redisTemplate.opsForHash();

        Product product = productService.getProductById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem existingItem = hashOps.get(cartKey, productId.toString());

        if (existingItem != null) {
            existingItem.setQuantity(existingItem.getQuantity() + quantity);
            existingItem.setSubtotal(
                    existingItem.getPrice().multiply(BigDecimal.valueOf(existingItem.getQuantity()))
            );
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProductId(productId);
            cartItem.setProductName(product.getName());
            cartItem.setPrice(product.getPrice());
            cartItem.setQuantity(quantity);
            cartItem.setSubtotal(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
            existingItem = cartItem;
        }

        hashOps.put(cartKey, productId.toString(), existingItem);
        redisTemplate.expire(cartKey, CART_EXPIRY_HOURS, TimeUnit.HOURS);

        log.info("🛒 Added {} x {} to cart for user {}", quantity, product.getName(), userId);
    }

    public List<CartItem> getCartItems(String userId) {
        String cartKey = CART_PREFIX + userId;
        HashOperations<String, String, CartItem> hashOps = redisTemplate.opsForHash();

        Map<String, CartItem> cartMap = hashOps.entries(cartKey);
        return new ArrayList<>(cartMap.values());
    }

    public void removeFromCart(String userId, Long productId) {
        String cartKey = CART_PREFIX + userId;
        redisTemplate.opsForHash().delete(cartKey, productId.toString());
        log.info("🗑️ Removed product {} from cart for user {}", productId, userId);
    }

    public void clearCart(String userId) {
        String cartKey = CART_PREFIX + userId;
        redisTemplate.delete(cartKey);
        log.info("🧹 Cleared cart for user {}", userId);
    }

    public BigDecimal getCartTotal(String userId) {
        List<CartItem> items = getCartItems(userId);
        return items.stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
