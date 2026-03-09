# Kafka Consumer - Spring Boot

A Spring Boot application that acts as a Kafka **message consumer**. It listens to two separate topics — one for plain strings and one for `Customer` objects — using dedicated listener container factories configured via a Java `@Configuration` class.

## How It Works

- `KafkaConsumerConfig` defines two separate `ConsumerFactory` and `ConcurrentKafkaListenerContainerFactory` beans — one for `String`, one for `Customer`
- `@KafkaListener` on each method uses the `containerFactory` attribute to route to the correct factory
- `string-topic` messages are deserialized as plain strings
- `customer-topic` messages are deserialized into `Customer` objects using `JacksonJsonDeserializer`
- Type headers from the producer are ignored — the consumer uses a fixed default type, making it work across different package structures

## Tech Stack

- Java 21+
- Spring Boot
- Spring Kafka (`@KafkaListener`, `ConsumerFactory`, `ConcurrentKafkaListenerContainerFactory`)
- Jackson (`JacksonJsonDeserializer`)
- Lombok
- SLF4J (logging)
- Apache Kafka + Zookeeper

## Project Structure

```
src/
├── service/
│   └── KafkaMessageListener.java   # @KafkaListener methods for string and Customer
├── dto/
│   └── Customer.java               # DTO matching producer schema
└── config/
    └── KafkaConsumerConfig.java    # Two ConsumerFactory + ContainerFactory beans
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

Once running you will see logs like:

```
INFO  consumer consume the message user 1
INFO  Consumer consume the Customer Customer(id=1, name=Subham, email=subham@example.com, contactNo=9876543210)
```

## Kafka Configuration (Java-based)

Instead of `application.yml`, Kafka is configured via `KafkaConsumerConfig.java` with two independent factory setups:

### String Consumer Factory
```java
props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
props.put(ConsumerConfig.GROUP_ID_CONFIG, "group-1");
props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JacksonJsonDeserializer.class);
```

### Customer Consumer Factory
```java
// Same base config plus:
props.put(JacksonJsonDeserializer.TRUSTED_PACKAGES, "*");
props.put(JacksonJsonDeserializer.USE_TYPE_INFO_HEADERS, false);
props.put(JacksonJsonDeserializer.VALUE_DEFAULT_TYPE, "com.subham.kafka_consumer_example.dto.Customer");
```

### Key Config Explained

| Property | Purpose |
|----------|---------|
| `TRUSTED_PACKAGES` | Whitelists packages allowed for deserialization (security measure) |
| `VALUE_DEFAULT_TYPE` | Tells the deserializer which class to map the JSON to |
| `USE_TYPE_INFO_HEADERS: false` | Ignores type headers from producer — works even when packages differ |

### Listener Routing

Each `@KafkaListener` method explicitly declares which factory to use:

```java
@KafkaListener(topics = "string-topic", containerFactory = "stringKafkaListenerContainerFactory")
public void consumeString(String message) { ... }

@KafkaListener(topics = "customer-topic", containerFactory = "customerKafkaListenerContainerFactory")
public void consumeCustomer(Customer customer) { ... }
```

## application.yml

Kafka config is intentionally absent from `application.yml` — everything is in the config class.

```yaml
spring:
  application:
    name: kafka-consumer-example

server:
  port: 9292
```

## Related Project

This app consumes messages published by the [kafka-producer-example](../kafka-producer-example/README.md).