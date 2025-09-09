# 🌱 Autowiring in Spring

## 🔹 What is Autowiring?

Autowiring in Spring **automatically injects object dependencies** into a bean without the need for explicit
`<property>` or `<constructor-arg>` configuration.

- It internally uses **setter injection** or **constructor injection**.

---

## ✅ Advantages of Autowiring

- Requires **less code** (no need to explicitly wire dependencies in XML).
- Makes the configuration **cleaner and faster**.

---

## ⚠️ Disadvantages of Autowiring

- **Less control** over program flow.
- Can create **confusion** if multiple beans of the same type exist.

---

## 🛠️ Ways to Use Autowiring

1. **XML Configuration** (`autowire` attribute in `<bean>`)
2. **Annotations** (`@Autowired`, `@Qualifier`, `@Primary`)

---

## 🔄 Autowiring Modes

| Mode             | Description                                                      |
|------------------|------------------------------------------------------------------|
| **no** (default) | No autowiring. Dependencies must be injected manually.           |
| **byName**       | Matches dependency **by property name** with bean id in context. |
| **byType**       | Matches dependency **by property type**.                         |
| **constructor**  | Injects dependency using constructor arguments.                  |
| **autodetect**   | Deprecated since Spring 3. First tries constructor, then byType. |

---
#### To enable annotation-based autowiring in XML configuration, add:`<context:annotation-config/>`
## ✨ Example: Annotation-based Autowiring

```java
public class Student {
    @Autowired
    private Address address;  // Automatically injected
}
```

## 🔑 Important Points about Annotation-based Autowiring

- If **multiple beans of the same type** exist → use `@Qualifier("beanName")` along with `@Autowired` to avoid
  ambiguity.
- `@Qualifier` **cannot be placed directly on the constructor**, but you can use it on the **constructor parameter**:

  ```java
  @Autowired
  public Student(@Qualifier("homeAddress") Address address) {
      this.address = address;
  } 
- But in **Setter method** and **field** you can use directly.
  - Setter example
      ```java
    @Autowired
    @Qualifier("homeAddress")
    public void setAddress(Address address) {
        System.out.println("by setter injection");
        this.address = address;
    } 
  - Field Example
    ```java
        @Autowired
        @Qualifier("officeAddress")
        private Address address;

# 🌱 Spring Stereotype Annotations

### 🔹 @Component
- Marks a class as a **Spring bean** (managed by the Spring container).
- No need to declare the bean in XML manually.
- Detected automatically when **component scanning** is enabled.
### 🔹 @Value
- Used for injecting values into fields, constructor arguments, or method parameters.
- Supports literals, property placeholders, and SpEL (Spring Expression Language).
    ```java
    @Component("st")
    public class Student {
        @Value("101")
        private int id;
        @Value("subham")
        private String name;
### 🔹@Primary with @Qualifier
- **@Primary** → for the bean you’ll use **most of the time** (default bean).
- **@Qualifier** → for **special cases** where you need a different bean.  
     ```java
    @Component("person1")
    public class Person {
       private final Car car;
       public Person(@Qualifier("toyota") Car car) {
          this.car = car;
       }
       public void startJourney() {
          car.drive();
       }
    }        

### 🌱 Spring Bean Scopes

- **prototype** → Scopes the bean definition to **multiple instances** (a new object every time it is requested).
- **request** → Scopes the bean definition to an **HTTP request**. A new bean instance is created for each request. *(Valid only in web-aware Spring ApplicationContext)*
- **session** → Scopes the bean definition to an **HTTP session**. A new bean instance is created for each session. *(Valid only in web-aware Spring ApplicationContext)*
- **global-session** → Scopes the bean definition to a **global HTTP session** (used in portlet-based web apps). *(Valid only in web-aware Spring ApplicationContext)*  
