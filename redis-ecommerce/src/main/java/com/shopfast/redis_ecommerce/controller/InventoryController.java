package com.shopfast.redis_ecommerce.controller;

import com.shopfast.redis_ecommerce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @PostMapping("/initialize")
    public ResponseEntity<String> initializeInventory(
            @RequestParam Long productId,
            @RequestParam Integer stock) {

        inventoryService.initializeInventory(productId, stock);
        return ResponseEntity.ok("Inventory initialized");
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Integer> getStock(@PathVariable Long productId) {
        return ResponseEntity.ok(inventoryService.getStock(productId));
    }

    @PostMapping("/decrement")
    public ResponseEntity<String> decrementStock(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        boolean success = inventoryService.decrementStock(productId, quantity);
        if (success) {
            return ResponseEntity.ok("Stock decremented");
        } else {
            return ResponseEntity.badRequest().body("Insufficient stock");
        }
    }

    @PostMapping("/increment")
    public ResponseEntity<String> incrementStock(
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        inventoryService.incrementStock(productId, quantity);
        return ResponseEntity.ok("Stock incremented");
    }
}
