# 🚀 Kafka with Docker Compose (Confluent Platform)

A single-node Apache Kafka setup using **Confluent Platform** images and **Docker Compose** — built for local development and learning.

---

## 📌 What This Project Does

Spins up a minimal Kafka environment locally using Docker:

- ✅ 1 Zookeeper node (metadata management)
- ✅ 1 Kafka broker (message streaming)
- ✅ Exposed on localhost for easy testing

> Perfect for learning Kafka fundamentals before moving to production-grade multi-broker clusters.

---

## 🐳 Tech Stack

| Tool | Version |
|------|---------|
| Docker Compose | Latest |
| Confluent Kafka | `cp-kafka:7.4.0` |
| Confluent Zookeeper | `cp-zookeeper:7.4.0` |

---

## 📦 Services

```yaml
services:
  zookeeper:
    image: confluentinc/cp-zookeeper:7.4.0
    container_name: my_zookeeper
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
      ZOOKEEPER_TICK_TIME: 2000

  kafka:
    image: confluentinc/cp-kafka:7.4.0
    container_name: my_kafka
    depends_on:
      - zookeeper
    ports:
      - "9092:9092"
    environment:
      KAFKA_BROKER_ID: 1
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://localhost:9092
      KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1
```

---

## ⚙️ Configuration Explained

| Variable | Purpose |
|----------|---------|
| `KAFKA_BROKER_ID: 1` | Unique ID assigned to this broker |
| `KAFKA_ZOOKEEPER_CONNECT` | Tells Kafka where Zookeeper is running |
| `KAFKA_ADVERTISED_LISTENERS` | Exposes Kafka to clients on `localhost:9092` |
| `KAFKA_OFFSETS_TOPIC_REPLICATION_FACTOR: 1` | Required for single-broker setup (no replication) |

---

## 🚀 How to Run

**Step 1 — Start the containers**
```bash
docker-compose up -d
```

**Step 2 — Verify containers are running**
```bash
docker ps
```

**Step 3 — Enter the Kafka container**
```bash
docker exec -it my_kafka bash
```

---

## 🧪 Testing Kafka

### Create a Topic
```bash
kafka-topics --create \
  --topic test-topic \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 \
  --partitions 1
```

### List Topics
```bash
kafka-topics --list --bootstrap-server localhost:9092
```

### Produce Messages
```bash
kafka-console-producer \
  --topic test-topic \
  --bootstrap-server localhost:9092
```

### Consume Messages
```bash
kafka-console-consumer \
  --topic test-topic \
  --from-beginning \
  --bootstrap-server localhost:9092
```

---

## 📚 What I Learned

- Difference between **standalone Kafka** (Windows install) and **Docker-based Confluent Kafka**
- How Zookeeper and Kafka broker communicate inside a Docker network
- Why `REPLICATION_FACTOR: 1` is required for single-broker setups
- How to produce and consume messages end-to-end

---

## 🔮 Upcoming Improvements

- [ ] Multi-broker cluster setup
- [ ] Add Schema Registry
- [ ] Integrate Kafka UI (Kafdrop or Control Center)
- [ ] Test partitioning and replication strategies
- [ ] Add a Java Spring Boot producer/consumer service

---

## 🙌 Author

Learning Kafka hands-on — from Windows installation → Docker Compose → Confluent Platform.  
Part of my backend engineering learning journey. 🚀