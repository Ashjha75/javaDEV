# Mysql Notes from videos
- by default mysql is case insensitive but can be made case sensitive by changing the collation.
example:
```sql
SELECT * FROM table_name WHERE first_name = 'Ashish'; // will return ashish, ASHISH, aSHISH etc.
```
but if we use binary collation then it will be case sensitive.
```sql
SELECT * FROM table_name WHERE binary first_name = 'Ashish' ; // will return only Ashish
```


### About Primary Key
- Primary key is a column or a set of columns that uniquely identifies each row in a table.
- Primary key must contain unique values and it cannot contain null values.
- Multiple columns can be included in primary key and make a single primary key.
example
```sql
CREATE TABLE table_name(
    firstname datatype,
    lastname datatype,
    PRIMARY KEY(firstname, lastname);
```
here primary key will be combination of firstname and lastname. ashish-jha  is primary key here means both first name and last name should match for a row to be unique.

### About unique constraints
- As all table can have max 1 primary key, but can have multiple unique constraints.
- unique constraints are used to enforce uniqueness of a column or a set of columns.
- unique key can also be Null depending upon the database like for mysql it can be null form multiple rows but for other
databases like oracle it can be null for only one row.

## DDL VS DML
- DDL(Data Definition Language) is used to define the structure that holds the data. e.g. CREATE, ALTER, DROP, TRUNCATE, COMMENT, RENAME

- DML(Data Manipulation Language) is used to manage the data itself. e.g. SELECT, INSERT, UPDATE, DELETE

- Truncate is DDL command because it just Drop the complete table and recreate it.
- Truncate is faster than delete as it does not log each row deletion in transaction log.