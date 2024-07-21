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
- `CONCAT()` : Concatenates two or more strings
- `LENGTH()` : Returns the length of a string
- `LOWER()` : Converts a string to lowercase
- `UPPER()` : Converts a string to uppercase
- `SUBSTRING()` : Extracts a substring from a string
- `REPLACE()` : Replaces a substring in a string
- `REVERSE()` : Reverses a string
