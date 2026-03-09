# Kafka Producer - Spring Boot

A Spring Boot application that acts as a Kafka **message producer**. It publishes plain string messages and serialized `Customer` objects to separate Kafka topics. Kafka configuration is handled entirely through a Java `@Configuration` class instead of `application.yml`.

## How It Works

- A GET request to `/producer-app/publish/{message}` sends string messages to `string-topic`
- A POST request to `/producer-app/publish` accepts a `Customer` JSON body and sends it to `customer-topic`
- `KafkaProducerConfig` manually wires up `ProducerFactory` and `KafkaTemplate` as Spring beans
- `JacksonJsonSerializer` handles serialization of both strings and objects
- Topics are created programmatically with specific partition counts in the config class

## Tech Stack

- Java 21+
- Spring Boot
- Spring Kafka (`KafkaTemplate`, `ProducerFactory`)
- Jackson (`JacksonJsonSerializer`)
- Lombok
- Apache Kafka + Zookeeper

## Project Structure

```
src/
├── controller/
│   └── EventController.java        # REST endpoints
├── service/
│   └── KafkaMessagePublisher.java  # Kafka send logic
├── dto/
│   └── Customer.java               # DTO for object publishing
└── config/
    └── KafkaProducerConfig.java    # ProducerFactory, KafkaTemplate, topic beans
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

Publishes 9 messages (`message 1` ... `message 9`) to `string-topic`.

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

Publishes the Customer as a serialized JSON object to `customer-topic`.

## Kafka Configuration (Java-based)

Instead of `application.yml`, Kafka is configured via `KafkaProducerConfig.java`:

```java
props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JacksonJsonSerializer.class);
```

### Topics Created

| Topic | Partitions | Purpose |
|-------|-----------|---------|
| `string-topic` | 2 | Plain string messages |
| `customer-topic` | 3 | Serialized Customer objects |

## application.yml

Kafka config is intentionally absent from `application.yml` — everything is in the config class.

```yaml
spring:
  application:
    name: kafka-producer-example

server:
  port: 9191
```

## Related Project

Pair this with the [kafka-consumer-example](../kafka-consumer-example/README.md) to see messages being deserialized and logged in real time.