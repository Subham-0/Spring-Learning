# 🌱 Autowiring in Spring

## 🔹 What is Autowiring?
Autowiring in Spring **automatically injects object dependencies** into a bean without the need for explicit `<property>` or `<constructor-arg>` configuration.
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

| Mode             | Description                                                                 |
|------------------|-----------------------------------------------------------------------------|
| **no** (default) | No autowiring. Dependencies must be injected manually.                      |
| **byName**       | Matches dependency **by property name** with bean id in context.            |
| **byType**       | Matches dependency **by property type**.                                    |
| **constructor**  | Injects dependency using constructor arguments.                             |
| **autodetect**   | Deprecated since Spring 3. First tries constructor, then byType.            |

---

## ✨ Example: Annotation-based Autowiring
```java
@Component
public class Employee {
    @Autowired
    private Address address;  // Automatically injected
}
