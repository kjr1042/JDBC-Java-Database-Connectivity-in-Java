# JDBC-Java-Database-Connectivity-in-Java
This repository is dedicated to providing comprehensive examples and explanations for working with JDBC (Java Database Connectivity) in Java applications. JDBC is a fundamental API that allows Java applications to interact with databases, enabling tasks such as establishing connections, executing SQL queries, and processing results.

Explore a variety of scenarios related to JDBC in Java, including:

Establishing database connections using different drivers and connection parameters.
Executing SQL queries (SELECT, INSERT, UPDATE, DELETE) and processing results.
Handling transactions for maintaining data integrity.
Implementing prepared statements for preventing SQL injection attacks.

## Key Concepts

### 1. Database Connection Establishing.
- **Description**: Establishing a connection to the database using JDBC.
- **Example**:
  ```java
  String url = "jdbc:mysql://localhost:3306/mydatabase";
  String username = "user";
  String password = "password";
  Connection connection = DriverManager.getConnection(url, username, password);
  Statement statement = connection.createStatement();
  ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
  while (resultSet.next()) {
    int id = resultSet.getInt("id");
    String name = resultSet.getString("name");
    // Process the row data
  }
  try {
    connection.setAutoCommit(false);
    // Execute multiple SQL statements as part of a transaction
    connection.commit();
  } catch (SQLException e) {
    connection.rollback();
  } finally {
    connection.setAutoCommit(true);
  }


