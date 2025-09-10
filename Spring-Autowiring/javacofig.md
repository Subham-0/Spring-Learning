## 🌱 Spring Java Configuration

[This project demonstrates how to configure beans in Spring using Java-based configuration instead of XML.](src/main/java/com/subham/javaconfig/)

### 📌 1. Using `@Configuration` and `@Bean`

`@Configuration` → marks the class as a source of bean definitions.

`@Bean` → explicitly defines and returns a bean inside the config class.

Best when you need full control over how the object is created (e.g., third-party classes).

### 📌 2. Using `@Component` and `@ComponentScan`

`@Component` → marks a class as a Spring-managed bean.

`@ComponentScan` → tells Spring to automatically search the package and register all `@Component` classes as beans.

Best when you want automatic bean detection and registration without writing extra bean methods.