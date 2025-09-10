## Spring-JDBC
***
- Spring JdbcTemplate is a powerful mechanism to connect to the database and execute sql query
- It internally uses JDBC api, but eliminates a lot of problem of JDBC API
  - ###  Problem of JDBC API
    - We need to write a lot of code before and after executing the query, such as creating connection,statement, closing resultset, connection etc.
    - We need to perform exception handing code on the data base logic.
    - Repetition of all these code.
## Advantage of Spring JdbcTemplate
***
- Spring JdbcTemplate eliminates all the above-mentioned problem JDBC API
- It provides methods to write the queries directly, so it saves a lot of work and time.
- Spring Jdbc Provide JdbcTemplate which has all the important method to perform operation with database.