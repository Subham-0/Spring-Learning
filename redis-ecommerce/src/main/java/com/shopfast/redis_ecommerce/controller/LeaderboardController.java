package com.shopfast.redis_ecommerce.controller;

import com.shopfast.redis_ecommerce.service.LeaderboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/leaderboard")
@RequiredArgsConstructor
public class LeaderboardController {
    private final LeaderboardService leaderboardService;

    @PostMapping("/purchase")
    public ResponseEntity<String> recordPurchase(
            @RequestParam Long productId,
            @RequestParam String productName) {

        leaderboardService.incrementPurchaseCount(productId, productName);
        return ResponseEntity.ok("Purchase recorded");
    }

    @GetMapping("/best-sellers")
    public ResponseEntity<Map<String, Double>> getBestSellers(
            @RequestParam(defaultValue = "10") int limit) {

        return ResponseEntity.ok(leaderboardService.getTopBestSellers(limit));
    }

    @GetMapping("/rank")
    public ResponseEntity<Long> getProductRank(
            @RequestParam Long productId,
            @RequestParam String productName) {

        Long rank = leaderboardService.getProductRank(productId, productName);
        return ResponseEntity.ok(rank);
    }
}
