package com.shopfast.redis_ecommerce.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaderboardService {

    private final RedisTemplate<String, Object> redisTemplate;
    private static final String BEST_SELLERS_KEY = "leaderboard:best_sellers";

    public void incrementPurchaseCount(Long productId, String productName) {
        redisTemplate.opsForZSet().incrementScore(
                BEST_SELLERS_KEY,
                productId + ":" + productName,
                1
        );
        log.info("📊 Incremented purchase count for {}", productName);
    }

    public Map<String, Double> getTopBestSellers(int topN) {
        Set<ZSetOperations.TypedTuple<Object>> topProducts =
                redisTemplate.opsForZSet().reverseRangeWithScores(BEST_SELLERS_KEY, 0, topN - 1);

        Map<String, Double> leaderboard = new LinkedHashMap<>();

        if (topProducts != null) {
            for (ZSetOperations.TypedTuple<Object> tuple : topProducts) {
                String productInfo = (String) tuple.getValue();
                Double score = tuple.getScore();
                leaderboard.put(productInfo, score);
            }
        }

        return leaderboard;
    }

    public Long getProductRank(Long productId, String productName) {
        Long rank = redisTemplate.opsForZSet().reverseRank(
                BEST_SELLERS_KEY,
                productId + ":" + productName
        );
        return rank != null ? rank + 1 : null;
    }
}
