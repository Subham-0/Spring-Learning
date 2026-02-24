# Kafka Producer - Spring Boot

A Spring Boot application that acts as a Kafka **message producer**. It exposes a REST endpoint that publishes messages to a Kafka topic.

## How It Works

- A GET request hits the `/producer-app/publish/{message}` endpoint
- The controller calls `KafkaMessagePublisher` which uses `KafkaTemplate` to send the message to `topic-1`
- Each send is handled asynchronously using `CompletableFuture`, logging success or failure to the console

## Tech Stack

- Java 17+
- Spring Boot
- Spring Kafka (`KafkaTemplate`)
- Apache Kafka + Zookeeper

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

## Publishing a Message

Use Postman or your browser to hit:

```
GET http://localhost:9191/producer-app/publish/user
```

This will publish 9,999 messages (`user 1`, `user 2` ... `user 9999`) to `topic-1`.

## Configuration

```yaml
spring:
  kafka:
    producer:
      bootstrap-servers: localhost:9092

server:
  port: 9191
```

## Related Project

Pair this with the [kafka-consumer-example](../kafka-consumer-example/README.md) to see messages being consumed in real time.