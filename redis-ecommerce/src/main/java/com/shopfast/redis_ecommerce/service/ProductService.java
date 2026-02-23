package com.shopfast.redis_ecommerce.service;

import com.shopfast.redis_ecommerce.model.Product;
import com.shopfast.redis_ecommerce.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    // USE CASE 1: Cache individual products
    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getProductById(Long id) {
        log.info("📦 Fetching product {} from DATABASE", id);
        return productRepository.findById(id);
    }

    // USE CASE 2: Cache all products
    @Cacheable(value = "products", key = "'all'")
    public List<Product> getAllProducts() {
        log.info("📦 Fetching ALL products from DATABASE");
        return productRepository.findAll();
    }

    // Create product
    public Product createProduct(Product product) {
        log.info("✅ Creating new product: {}", product.getName());
        return productRepository.save(product);
    }

    //Update product and update cache
    @CachePut(value = "products", key = "#product.id")
    public Product updateProduct(Product product) {
        log.info("🔄 Updating product {} in DATABASE and CACHE", product.getId());
        return productRepository.save(product);
    }

    // Delete product and remove from cache
    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(Long id) {
        log.info("🗑️ Deleting product {} from DATABASE and CACHE", id);
        productRepository.deleteById(id);
    }

    // Clear all product cache
    @CacheEvict(value = "products", allEntries = true)
    public void clearCache() {
        log.info("🧹 Clearing ALL product cache");
    }
}
