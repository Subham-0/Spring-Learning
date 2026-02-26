# ShopFast - Redis E-Commerce Platform 🛍️

A high-performance e-commerce application built with **Spring Boot** and **Redis**, demonstrating real-world Redis use cases including caching, shopping cart management, inventory tracking, and product leaderboards.

## 🚀 Features Implemented

- ✅ **Product Caching** - Lightning-fast product retrieval using Redis cache
- ✅ **Shopping Cart** - Real-time cart management with Redis Hash
- ✅ **Inventory Management** - Atomic stock operations
- ✅ **Product Leaderboard** - Track best-selling products with Redis Sorted Sets

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.4.2**
- **Spring Data JPA**
- **Spring Data Redis**
- **PostgreSQL**
- **Redis 7**
- **Docker & Docker Compose**
- **Lombok**
- **Maven**

## 📋 Prerequisites

- Java 17 or higher
- Docker and Docker Compose
- Maven 3.6+
- Git

## 🏃 Quick Start

### 1. Clone the repository
```bash
git clone https://github.com/Subham-0/shopfast-redis.git
cd shopfast-redis
```

### 2. Start Redis and PostgreSQL
```bash
docker-compose up -d
```

### 3. Run the application
```bash
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 🗄️ Database Schema

The application uses PostgreSQL with the following main entity:

**Product Table:**
- id (Primary Key)
- name
- description
- price
- stock
- category
- imageUrl
- createdAt

## 🔑 Redis Use Cases

### 1. Product Caching
```java
@Cacheable(value = "products", key = "#id")
public Optional<Product> getProductById(Long id)
```
- Caches individual products
- 10-minute TTL
- Automatic cache invalidation on updates

### 2. Shopping Cart (Redis Hash)
```
Key: cart:userId
Field: productId
Value: CartItem object
```

### 3. Inventory Management (Atomic Operations)
```
Key: inventory:productId
Value: stock count
Operations: INCR/DECR
```

### 4. Leaderboard (Sorted Set)
```
Key: leaderboard:best_sellers
Member: productId:productName
Score: purchase count
```

## 📡 API Endpoints

### Products
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Create product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### Shopping Cart
- `POST /api/cart/add?productId={id}&quantity={qty}` - Add to cart
- `GET /api/cart` - Get cart items
- `GET /api/cart/total` - Get cart total
- `DELETE /api/cart/remove/{productId}` - Remove from cart
- `DELETE /api/cart/clear` - Clear cart

**Header Required:** `User-Id: user123`

### Inventory
- `POST /api/inventory/initialize?productId={id}&stock={qty}` - Initialize inventory
- `GET /api/inventory/{productId}` - Get stock
- `POST /api/inventory/decrement?productId={id}&quantity={qty}` - Decrease stock
- `POST /api/inventory/increment?productId={id}&quantity={qty}` - Increase stock

### Leaderboard
- `POST /api/leaderboard/purchase?productId={id}&productName={name}` - Record purchase
- `GET /api/leaderboard/best-sellers?limit={n}` - Get top N sellers
- `GET /api/leaderboard/rank?productId={id}&productName={name}` - Get product rank

## 🧪 Testing the Application

### 1. Create a Product
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "name": "iPhone 15 Pro",
    "description": "Latest Apple smartphone",
    "price": 999.99,
    "stock": 50,
    "category": "Electronics"
  }'
```

### 2. Get Product (First call - DB, Second call - Cache)
```bash
curl http://localhost:8080/api/products/1
```

### 3. Add to Cart
```bash
curl -X POST "http://localhost:8080/api/cart/add?productId=1&quantity=2" \
  -H "User-Id: user123"
```

### 4. View Cart
```bash
curl http://localhost:8080/api/cart -H "User-Id: user123"
```

### 5. Initialize Inventory
```bash
curl -X POST "http://localhost:8080/api/inventory/initialize?productId=1&stock=100"
```

### 6. Record Purchase for Leaderboard
```bash
curl -X POST "http://localhost:8080/api/leaderboard/purchase?productId=1&productName=iPhone%2015%20Pro"
```

### 7. View Best Sellers
```bash
curl "http://localhost:8080/api/leaderboard/best-sellers?limit=5"
```

## 🔍 Verify Redis Data

Connect to Redis CLI:
```bash
docker exec -it shopfast-redis redis-cli
```

Check cached data:
```redis
KEYS *
GET "products::1"
HGETALL cart:user123
GET inventory:1
ZREVRANGE leaderboard:best_sellers 0 9 WITHSCORES
```

## 📊 Application Logs

Watch for these log messages to understand cache behavior:
- `📦 Fetching product from DATABASE` - Cache miss
- `🛒 Added to cart` - Cart update
- `✅ Stock decremented` - Inventory change
- `📊 Incremented purchase count` - Leaderboard update

## 🏗️ Project Structure
```
src/main/java/com/shopfast/redis_ecommerce/
├── config/
│   └── RedisConfig.java
├── controller/
│   ├── ProductController.java
│   ├── CartController.java
│   ├── InventoryController.java
│   └── LeaderboardController.java
├── dto/
│   └── CartItem.java
├── model/
│   └── Product.java
├── repository/
│   └── ProductRepository.java
├── service/
│   ├── ProductService.java
│   ├── ShoppingCartService.java
│   ├── InventoryService.java
│   └── LeaderboardService.java
└── RedisEcommerceApplication.java
```

## 🐳 Docker Services
```yaml
services:
  redis:
    - Port: 6379
    - Persistence: Enabled (AOF)
  
  postgres:
    - Port: 5432
    - Database: shopfast
    - User: postgres
```

## 🔧 Configuration

Key configurations in `application.yml`:
- Redis connection: `localhost:6379`
- PostgreSQL: `localhost:5432/shopfast`
- Cache TTL: 10 minutes
- Server port: 8080

## 📝 License

This project is created for educational purposes.

## 👨‍💻 Author

Your Name - Learning Redis with Spring Boot

## 🙏 Acknowledgments

- Spring Boot Documentation
- Redis Documentation
- Spring Data Redis

---

**Note:** This is Phase 1 of the project. More features (Rate Limiting, Flash Sales, Pub/Sub, Analytics) will be added in future phases.