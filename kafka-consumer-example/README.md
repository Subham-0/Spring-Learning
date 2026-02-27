# Kafka Consumer - Spring Boot

A Spring Boot application that acts as a Kafka **message consumer**. It listens to a Kafka topic, deserializes incoming JSON into a `Customer` object, and logs it to the console in real time.

## How It Works

- `KafkaMessageListener` uses `@KafkaListener` bound to `topic-1` and `group-1`
- Incoming messages are automatically deserialized from JSON into a `Customer` object using `JacksonJsonDeserializer`
- The deserialized Customer is logged to the console via SLF4J
- Type headers from the producer are intentionally ignored — the consumer uses a fixed default type (`Customer`) instead, making it work even when the producer and consumer are in different packages

## Tech Stack

- Java 21+
- Spring Boot
- Spring Kafka (`@KafkaListener`)
- Jackson (`JacksonJsonDeserializer`)
- Lombok
- SLF4J (logging)
- Apache Kafka + Zookeeper

## Project Structure

```
src/
├── service/
│   └── KafkaMessageListener.java  # Kafka consumer logic
└── dto/
    └── Customer.java              # DTO matching producer schema
```

## Prerequisites

Make sure Kafka and Zookeeper are running locally before starting this app.

**Start Zookeeper:**
```bash
zookeeper-server-start.bat config/zookeeper.properties
```

**Start Kafka Broker:**
```bash
kafka-server-start.bat config/server.properties
```

## Running the App

```bash
mvn spring-boot:run
```

App runs on **port 9292**.

Once running, the consumer will automatically start listening. When a Customer message arrives you will see:

```
INFO  Consumer consume the Customer Customer(id=1, name=Subham, email=subham@example.com, contactNo=9876543210)
```

## Configuration

```yaml
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: group-1
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      value-deserializer: org.springframework.kafka.support.serializer.JacksonJsonDeserializer
      properties:
        spring.json.trusted.packages: "com.subham.kafka_consumer_example.dto"
        spring.json.value.default.type: com.subham.kafka_consumer_example.dto.Customer
        spring.json.use.type.headers: false

server:
  port: 9292
```

### Key Config Explained

| Property | Purpose |
|----------|---------|
| `trusted.packages` | Whitelists packages allowed for deserialization (security measure) |
| `value.default.type` | Tells the deserializer which class to map the JSON to |
| `use.type.headers: false` | Ignores type headers from producer — useful when producer and consumer are in different packages |

## Verifying with Offset Explorer

Use **Offset Explorer** to verify:
- Messages distributed across all 5 partitions of `topic-1`
- Consumer offset advancing as messages are consumed
- Lag dropping to 0 once all messages are processed

## Related Project

This app consumes messages published by the [kafka-producer-example](../kafka-producer-example/README.md).