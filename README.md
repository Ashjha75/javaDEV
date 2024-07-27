# My SQL <img src="https://www.mysql.com/common/logos/powered-by-mysql-88x31.png" style="border-radius: 10px">

> _for Cheatsheet reference :_  &nbsp; &nbsp;    [My Sql Cheatsheet](https://quickref.me/mysql)

***This is for only in depth explanation of the concepts.***
## Table of Contents
- [Introduction](#introduction)
- [Installation](#installation)
- [Basic Commands](#basic-commands)
- [Data Types](#data-types)
- [Operators](#operators)
- [Functions](#functions)
- [Constraints](#constraints)
- [Create commands](#create-commands)
- [Insert commands](#insert-commands)
- [Select commands](#select-commands)
- [Update commands](#update-commands)
- [Delete commands](#delete-commands)
- [Drop commands](#drop-commands)
- [Alter commands](#alter-commands)
- [Truncate commands](#truncate-commands)
- [Joins](#joins)
- [Sub Queries](#sub-queries)
- [Views](#views)
- [Transactions](#transactions)
- [Indexes](#indexes)
- [Triggers](#triggers)
- [Stored Procedures](#stored-procedures)
- [Events](#events)
- [Cursors](#cursors)
- [Error Handling](#error-handling)
- [Performance Tuning](#performance-tuning)
- [Backup and Restore](#backup-and-restore)
- [Security](#security)
- [Interview Questions](#interview-questions)

## Introduction
- MySQL is an open-source relational database management system (RDBMS).
- MySQL is a database management system.
- MySQL is a database server.
- MySQL is ideal for both small and large applications.
- MySQL supports standard SQL.
- MySQL is free to download and use.
- MySQL is developed, marketed, and supported by MySQL AB, which is a Swedish company.
- MySQL is a relational database management system.
- MySQL's software is Open Source.

## Installation
- [Download MySQL](https://dev.mysql.com/downloads/mysql/)
- [Install MySQL](https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/)
- [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)
- [MySQL Community Server](https://dev.mysql.com/downloads/mysql/)
### For java there is need of mysql-connector-java
- [Download mysql-connector-java](https://dev.mysql.com/downloads/connector/j/)
- [Install mysql-connector-java](https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-installing.html)

## Basic Commands
- **Create Database**
```sql
CREATE DATABASE database_name;
```
- **Drop Database**
```sql
DROP DATABASE database_name;
```
- **Use Database**
```sql
USE database_name;
```
- **Show Databases**
```sql
SHOW DATABASES;
```
- **Create Table**
```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
   ....
);
```
- **Show Tables**
```sql
SHOW TABLES;
```
- **Describe Table**
```sql
DESCRIBE table_name;
```
- **Insert Data**
```sql
INSERT INTO table_name (column1, column2, column3, ...)
VALUES (value1, value2, value3, ...);
```
- **Select Data**
```sql
SELECT column1, column2, ...
FROM table_name;
```
- **Update Data**
```sql
UPDATE table_name
SET column1 = value1, column2 = value2, ...
WHERE condition;
```
- **Delete Data**
```sql
DELETE FROM table_name
WHERE condition;
```
- **Truncate Table**
```sql
TRUNCATE TABLE table_name;
```
- **Drop Table**
```sql
DROP TABLE table_name;
```
- **Alter Table**
```sql
ALTER TABLE table_name  ADD column_name datatype;
ALTER TABLE table_name  DROP COLUMN column_name;
ALTER TABLE table_name  MODIFY COLUMN column_name datatype;
```
- **Rename Table**
```sql
RENAME TABLE table_name TO new_table_name;
```
- **Create Index**
```sql
CREATE INDEX index_name
ON table_name (column1, column2, ...);
```
- **Drop Index**
```sql
DROP INDEX index_name
ON table_name;
```
- **Create View**
```sql
CREATE VIEW view_name AS
SELECT column1, column2, ...
FROM table_name
WHERE condition;
```
- **Drop View**
```sql
DROP VIEW view_name;
```

## Data Types

MySQL supports a variety of data types categorized into several broad types:

#### Numeric Data Types
- **INT**: Standard integer, suitable for a wide range of values.
- **TINYINT**: Small integer, ideal for small numbers.
- **SMALLINT**: Larger than `TINYINT`, for slightly larger integers.
- **MEDIUMINT**: Medium-sized integers.
- **BIGINT**: For very large integer values.
- **FLOAT**: Single-precision floating point.
- **DOUBLE**: Double-precision floating point for more precision.
- **DECIMAL**: For exact numeric values with specified precision.

#### Date and Time Data Types
- **DATE**: Stores a date (YYYY-MM-DD).
- **TIME**: Stores a time (HH:MM:SS).
- **DATETIME**: Stores both date and time (YYYY-MM-DD HH:MM:SS).
- **TIMESTAMP**: Similar to `DATETIME`, used for tracking changes.
- **YEAR**: Stores a year in 2-digit or 4-digit format.

#### String Data Types
- **CHAR**: Fixed-length string.
- **VARCHAR**: Variable-length string.
- **TEXT**: For long text data, with variations like `TINYTEXT`, `MEDIUMTEXT`, and `LONGTEXT`.
- **BLOB**: For binary data, with variations like `TINYBLOB`, `MEDIUMBLOB`, and `LONGBLOB`.

#### JSON Data Type
- **JSON**: Stores JSON documents.

#### Spatial Data Types
- **GEOMETRY**: Can store any type of spatial data.
- **POINT**, **LINESTRING**, **POLYGON**: Specific types for storing points, lines, and polygons.
- **MULTIPOINT**, **MULTILINESTRING**, **MULTIPOLYGON**: For storing multiple points, lines, or polygons.
- **GEOMETRYCOLLECTION**: Can store a collection of different geometry types.

#### Miscellaneous Data Types
- **ENUM**: A string object with a value chosen from a list of permitted values.
- **SET**: Can store multiple values from a predefined list.

## Operators
Operators in MySQL are used to perform operations on variables and values. MySQL supports a wide range of operators, categorized into several types:

### Arithmetic Operators
- `+` : Addition
- `-` : Subtraction
- `*` : Multiplication
- `/` : Division
- `%` : Modulus

### Comparison Operators
- `=` : Equal to
- `>` : Greater than
- `<` : Less than
- `>=` : Greater than or equal to
- `<=` : Less than or equal to
- `<>` or `!=` : Not equal to

### Logical Operators
- `AND` or `&&` : Logical AND
- `OR` or `||` : Logical OR
- `NOT` or `!` : Logical NOT
- `XOR` : Logical exclusive OR

### Bitwise Operators
- `&` : Bitwise AND
- `|` : Bitwise OR
- `^` : Bitwise XOR
- `~` : Bitwise NOT
- `<<` : Left shift
- `>>` : Right shift

### String Operators
- `CONCAT()` : Concatenates two or more strings
- `CONCAT_WS()` : Concatenates strings with a separator
- `MATCH ... AGAINST` : Full-text search
- `LIKE` : Pattern matching with wildcards
- `REGEXP` or `RLIKE` : Pattern matching with regular expressions

### Assignment Operators
- `=` : Assign a value
- `:=` : Assign a value (alternative syntax)

### Other Operators
- `BETWEEN` : Between an inclusive range
- `IN` : In a list of values
- `IS NULL` : Is a NULL value
- `IS NOT NULL` : Is not a NULL value
- `EXISTS` : Exists in a subquery
- `CASE` : Conditional logic
- `INTERVAL` : Returns the index of the argument that is less than the first argument

These operators allow for complex expressions and queries, enabling powerful data manipulation and retrieval in MySQL.

## Functions
Functions in MySQL are used to perform operations on data. MySQL provides a wide range of built-in functions, categorized into several types:

### String Functions
- `CONCAT(str1, str2, ...)`: Concatenates two or more strings into one string.
- `LENGTH(str)`: Returns the length of a string in bytes.
- `LOWER(str)`: Converts a string to lowercase.
- `UPPER(str)`: Converts a string to uppercase.
- `REPLACE(str, from_str, to_str)`: Replaces all occurrences of a substring within a string.
- `SUBSTRING(str, pos, len)`: Extracts a substring from a string (starting at any position).
- `TRIM(str)`: Removes leading and trailing spaces from a string.

### Numeric Functions
- `ABS(x)`: Returns the absolute value of a number.
- `CEILING(x)`: Returns the smallest integer value that is greater than or equal to x.
- `FLOOR(x)`: Returns the largest integer value that is less than or equal to x.
- `ROUND(x, d)`: Rounds a number to a specified number of decimal places.
- `POW(x, y)`: Returns the value of x raised to the power of y.

### Date and Time Functions
- `CURDATE()`: Returns the current date.
- `CURTIME()`: Returns the current time.
- `DATE_ADD(date, INTERVAL expr type)`: Adds a time value (interval) to a date value.
- `DATEDIFF(endDate, startDate)`: Returns the number of days between two dates.
- `DAYNAME(date)`: Returns the name of the weekday for a given date.
- `NOW()`: Returns the current date and time.

### Aggregate Functions
- `AVG(column)`: Returns the average value of a column.
- `COUNT(column)`: Returns the number of rows that matches a specified criterion.
- `MAX(column)`: Returns the maximum value of a column.
- `MIN(column)`: Returns the minimum value of a column.
- `SUM(column)`: Returns the total sum of a numeric column.

### Miscellaneous Functions
- `CAST(value AS type)`: Converts a value (of any type) into a specified datatype.
- `COALESCE(value1, value2, ...)`: Returns the first non-null value in the list.
- `IF(condition, true_value, false_value)`: Returns a value if a condition is TRUE, or another value if FALSE.
- `NULLIF(value1, value2)`: Returns NULL if value1 equals value2; otherwise returns value1.


## Constraints
Constraints in MySQL are used to specify rules for data in a table. MySQL supports several types of constraints:

### Primary Key Constraint
- Ensures that each row in a table is unique and not null.
```sql
CREATE TABLE table_name (
    column1 datatype PRIMARY KEY,
    column2 datatype,
    ...
);
```
### Foreign Key Constraint
- Ensures the referential integrity of the data in one table to match values in another table.
```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    FOREIGN KEY (column1) REFERENCES other_table(column)
);
```

### Unique Constraint
- Ensures that all values in a column are unique.
```sql
CREATE TABLE table_name (
    column1 datatype UNIQUE,
    column2 datatype,
    ...
);
```
### Not Null Constraint
- Ensures that a column cannot have a NULL value.
```sql
CREATE TABLE table_name (
    column1 datatype NOT NULL,
    column2 datatype,
    ...
);
```
### Default Constraint
- Provides a default value for a column when no value is specified.
```sql
CREATE TABLE table_name (
    column1 datatype DEFAULT default_value,
    column2 datatype,
    ...
);
```
### Check Constraint
- Ensures that all values in a column satisfy a specific condition.
```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    ...
    CHECK (column1 > 0)
);
```
### Index Constraint
- Used to create and retrieve data from the database very quickly.
```sql
CREATE INDEX index_name
ON table_name (column1, column2, ...);
```
### Auto Increment Constraint
- Automatically generates a unique value for a column whenever a new row is inserted.
```sql
CREATE TABLE table_name (
    column1 datatype AUTO_INCREMENT,
    column2 datatype,
    ...
);
```


## Create commands
- **Create Database**
```sql
CREATE DATABASE database_name;
```
- **Create Table**
```sql
CREATE TABLE table_name (
    column1 datatype,
    column2 datatype,
    column3 datatype,
   ....
);
```


























# questions[]: # Path: README.md
# SQL Practice Questions

## Basic Queries
1. Select all columns from the `users` table.
2. Select the `userName` and `email` from the `users` table.
3. Select all transactions where the `amount` is greater than 100.
4. Select all wallets with a balance less than 500.
5. Select all cards that expire after '2024-01-01'.

## Filtering and Sorting
1. Select all users who are older than 30.
2. Select all transactions of type 'credit' and order them by `amount` in descending order.
3. Select all wallets and order them by `balance` in ascending order.
4. Select all cards and order them by `expiryDate` in descending order.
5. Select all payments with status 'completed' and order them by `recipient`.

## Aggregate Functions
1. Count the number of users in the `users` table.
2. Find the average balance in the `wallets` table.
3. Find the maximum amount in the `transactions` table.
4. Find the minimum balance in the `wallets` table.
5. Calculate the total amount of all 'debit' transactions.

## Group By
1. Count the number of transactions for each `userId`.
2. Find the total balance for each `currency` in the `wallets` table.
3. Find the average age of users grouped by `location`.
4. Count the number of cards for each `userId`.
5. Find the total amount of transactions grouped by `type`.

## Joins
1. Select all users and their corresponding wallets.
2. Select all transactions and the corresponding user details.
3. Select all cards and the corresponding user details.
4. Select all payments and the corresponding transaction details.
5. Select all users and their transactions where the transaction amount is greater than 200.

## Subqueries
1. Select all users who have made a transaction.
2. Select all users who have a wallet balance greater than the average balance.
3. Select all transactions where the amount is greater than the average amount.
4. Select all cards that belong to users who are older than 25.
5. Select all payments where the transaction amount is greater than 100.

## Data Manipulation
1. Insert a new user into the `users` table.
2. Update the balance of a wallet for a specific `userId`.
3. Delete a transaction with a specific `transactionId`.
4. Insert a new card for a specific `userId`.
5. Update the status of a payment to 'completed' for a specific `paymentId`.

## Advanced Queries
1. Select the top 5 users with the highest balance in their wallets.
2. Select the top 3 transactions with the highest amount.
3. Find the user with the most transactions.
4. Find the user with the highest total transaction amount.
5. Select all users who do not have a card.

## Complex Joins and Subqueries
1. Select all users and their total transaction amount.
2. Select all users and their total wallet balance.
3. Select all users and their total number of cards.
4. Select all transactions and the corresponding user and wallet details.
5. Select all payments and the corresponding user, transaction, and card details.

## Constraints and Indexes
1. Add a unique constraint to the `email` column in the `users` table.
2. Add a foreign key constraint to the `userId` column in the `cards` table.
3. Create an index on the `balance` column in the `wallets` table.
4. Add a not null constraint to the `password` column in the `users` table.
5. Create an index on the `transactionDate` column in the `transactions` table.