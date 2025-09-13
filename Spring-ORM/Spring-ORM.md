## Spring ORM
- Spring provide API to easily integrate Spring with ORM frameworks such as Hibernate, JPA(Java Persistence API), JDO(Java Data Objects), Oracle Toplink and iBATIS
- #### Advantage of ORM Frameworks with Spring
  - There are a lot of advantage of Spring framework in respect to ORM frameworks.
  - ##### Less coding is required.
    - By the help of Spring framework, you don't need to write extra codes before and after the actual database logic such as getting the connection, starting transaction, commiting transaction, closing connection etc.
  - ##### Easy to test:
    - Spring's IoC approach makes it easy to test the application.
  - ##### Better Exception handing:
    - Spring framework provides its own API for exception handling with ORM framework.
  - ##### Integrated transaction management:
By the help of Spring framework, we can warp our mapping code with an explicit template wrapper class or AOP style method interceptor.
## flow of Hibernate integration with Spring

### 1️⃣ DataSource

The DataSource object provides the database connection.

It holds:

- driverClassName → e.g., com.mysql.cj.jdbc.Driver

-  url → e.g., jdbc:mysql://localhost:3306/mydb

- username → database username

- password → database password

👉 Acts as the entry point for connecting Hibernate with the database.

### 2️⃣ LocalSessionFactoryBean

A Spring-provided factory bean that creates a Hibernate SessionFactory.

Needs:

-    DataSource → to know how to connect to DB.
    
-   Hibernate properties → e.g., hibernate.dialect, hibernate.show_sql, hibernate.hbm2ddl.auto.
    
-  Annotated classes or mappingResources → your entity classes with @Entity.

👉 It bridges between Spring’s DataSource and Hibernate’s SessionFactory.

### 3️⃣ SessionFactory

Core Hibernate object that provides Session objects.

- A Session is what Hibernate uses to interact with the DB (CRUD, queries, transactions).

- The SessionFactory is heavy, so it is created once and reused.

👉 Think of it as the factory that produces lightweight sessions for database work.

### 4️⃣ HibernateTemplate

A Spring helper class that simplifies Hibernate usage:

- Automatically handles opening/closing sessions.

- Wraps common operations (save, update, delete, find) into easy methods.

- Reduces boilerplate Hibernate code.

👉 Provides a Spring-style abstraction over raw Hibernate.