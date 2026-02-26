package com.shopfast.redis_ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
    private final RedisTemplate<String, Object> redisTemplate;

    private static final String INVENTORY_PREFIX = "inventory:";

    public void initializeInventory(Long productId, Integer stock) {
        String key = INVENTORY_PREFIX + productId;
        redisTemplate.opsForValue().set(key, stock);
        log.info("📦 Initialized inventory for product {}: {} units", productId, stock);
    }

    public boolean decrementStock(Long productId, Integer quantity) {
        String key = INVENTORY_PREFIX + productId;

        Long newStock = redisTemplate.opsForValue().decrement(key, quantity);

        if (newStock != null && newStock >= 0) {
            log.info("✅ Stock decremented for product {}: {} remaining", productId, newStock);
            return true;
        } else {
            // Rollback
            redisTemplate.opsForValue().increment(key, quantity);
            log.warn("❌ Insufficient stock for product {}", productId);
            return false;
        }
    }

    public void incrementStock(Long productId, Integer quantity) {
        String key = INVENTORY_PREFIX + productId;
        Long newStock = redisTemplate.opsForValue().increment(key, quantity);
        log.info("📈 Stock incremented for product {}: {} units", productId, newStock);
    }

    public Integer getStock(Long productId) {
        String key = INVENTORY_PREFIX + productId;
        Object stock = redisTemplate.opsForValue().get(key);
        return stock != null ? Integer.parseInt(stock.toString()) : 0;
    }
}
