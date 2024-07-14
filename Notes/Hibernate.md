# Hibernate notes

### Maven Dependencies

To use Hibernate, ensure your `pom.xml` includes dependencies for Hibernate Core and the MySQL JDBC Connector.

```xml
<dependencies>
    <dependency>
        <groupId>org.hibernate</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>5.4.30.Final</version>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.23</version>
    </dependency>
</dependencies>
```
### Hibernate Configuration
Hibernate requires a `hibernate.cfg.xml` file to configure the database connection. Specify the database driver, URL, username, and password.

```xml
<?xml version='1.0' encoding='utf-8'?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
    <session-factory>
        <!--        <property name="hibernate.connection.driver_class">org.h2.Driver</property>-->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <!--        <property name="hibernate.connection.url">jdbc:h2:~/test</property>-->
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/students</property>
        <property name="hibernate.connection.username">Ashish</property>
        <property name="hibernate.connection.password">********</property>
        <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
        <property name="show_sql">true</property>
        <property name="format_sql">true</property>
        <property name="use_sql_comments">true</property>
        <!--        <property name="hbm2ddl.auto">create</property>-->
        <property name="hbm2ddl.auto">update</property>
        <mapping class="org.ashish.model.Student" />
    </session-factory>
</hibernate-configuration>
```
# Entity Class
An entity class represents a table in your database. Use annotations like @Entity, @Table, and @Id to map class fields to table columns.

```java
package org.ashish.model;

import jakarta.persistence.*;

@Entity
@Table(name = "studentTable")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private int studentId;

    private String studentName;
    private String studentAddress;
    private String studentEmail;

    // Constructors, getters, and setters
//    @Override the to toString method to get the data in formatted way
}
```
# CRUD Operations

### SessionFactory Creation
SessionFactory is a heavyweight object, created once and reused. It's built from the configuration, specifying entity classes.

```java 
SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
```
### Inserting and Updating Entities
Use a Session to perform database operations. Begin a transaction, perform operations (e.g., save, merge), and commit the transaction.

```java
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

Student student = new Student();
student.setStudentName("New Name");
session.saveOrUpdate(student);

transaction.commit();
session.close();
```
### Deleting Entities
Similar to insert/update, but use session.delete(entity) to remove an entity from the database.

```java
Session session = sessionFactory.openSession();
Transaction transaction = session.beginTransaction();

Student student = session.get(Student.class, studentId);
if (student != null) {
    session.delete(student);
}

transaction.commit();
session.close();
```
### Fetching Entities
get(), load(), and getReference() are used to fetch entities. get() immediately hits the database, while load() and getReference() are lazy-loaded.

```java
Session session = sessionFactory.openSession();
Student student = session.get(Student.class, studentId);
session.close();
```