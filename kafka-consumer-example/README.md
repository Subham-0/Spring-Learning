# Kafka Consumer - Spring Boot

A Spring Boot application that acts as a Kafka **message consumer**. It listens to a Kafka topic and logs every incoming message in real time.

## How It Works

- `KafkaMessageListener` is annotated with `@KafkaListener` bound to `topic-1` and `group-1`
- Whenever a message is published to `topic-1`, this app automatically receives it
- The message is logged to the console using SLF4J

## Tech Stack

- Java 17+
- Spring Boot
- Spring Kafka (`@KafkaListener`)
- Apache Kafka + Zookeeper
- SLF4J (logging)

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

Once running, the consumer will automatically start listening to `topic-1`. You will see consumed messages printed in the terminal like:

```
INFO  consumer consume the message user 1
INFO  consumer consume the message user 2
...
```

## Configuration

```yaml
spring:
  kafka:
    consumer:
      bootstrap-servers: localhost:9092
      group-id: group-1

server:
  port: 9292
```

## Verifying with Offset Explorer

You can use **Offset Explorer** to visually verify:
- Messages distributed across partitions
- Current offset per partition
- Consumer lag (should drop to 0 once all messages are consumed)

## Related Project

This app consumes messages published by the [kafka-producer-example](../kafka-producer-example/README.md).