# Kafka Producer - Spring Boot

A Spring Boot application that acts as a Kafka **message producer**. It exposes REST endpoints to publish both plain string messages and serialized Java objects (Customer) to a Kafka topic.

## How It Works

- A GET request to `/producer-app/publish/{message}` publishes plain string messages to `topic-1`
- A POST request to `/producer-app/publish` accepts a `Customer` JSON body and publishes it as a serialized object
- `KafkaMessagePublisher` uses `KafkaTemplate` to send messages asynchronously via `CompletableFuture`
- Messages are serialized using `JacksonJsonSerializer` on the producer side
- `KafkaProducerConfig` programmatically creates `topic-1` with 5 partitions on startup

## Tech Stack

- Java 21+
- Spring Boot
- Spring Kafka (`KafkaTemplate`)
- Jackson (`JacksonJsonSerializer`)
- Lombok
- Apache Kafka + Zookeeper

## Project Structure

```
src/
├── controller/
│   └── EventController.java       # REST endpoints
├── service/
│   └── KafkaMessagePublisher.java # Kafka send logic
├── dto/
│   └── Customer.java              # DTO for object publishing
└── config/
    └── KafkaProducerConfig.java   # Topic creation config
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

App runs on **port 9191**.

## API Endpoints

### Publish String Messages

```
GET http://localhost:9191/producer-app/publish/{message}
```

Publishes 9,999 messages (`message 1` ... `message 9999`) to `topic-1`.

### Publish a Customer Object

```
POST http://localhost:9191/producer-app/publish
Content-Type: application/json

{
  "id": 1,
  "name": "Subham",
  "email": "subham@example.com",
  "contactNo": "9876543210"
}
```

## Configuration

```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.springframework.kafka.support.serializer.JacksonJsonSerializer

server:
  port: 9191
```

> **Note:** `spring.json.add.type.headers` is disabled. The consumer uses a fixed default type instead of relying on headers, which allows the producer and consumer to have different package structures.

## Related Project

Pair this with the [kafka-consumer-example](../kafka-consumer-example/README.md) to see Customer objects being deserialized and logged in real time.