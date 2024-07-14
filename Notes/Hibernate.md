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
# Steps 
1.  Create a Java class and annotate it with @Entity and @Table.
2.  Define fields and annotate them with @Id, @GeneratedValue, and @Column.
3.  Create a Hibernate configuration file (hibernate.cfg.xml) to configure the database connection.
4.  Create a SessionFactory object using the Configuration class.
5.  In SessionFactory, first make a new Configuration and configure it with the hibernate.cfg.xml file 
6.  (if name is same as hibernate.cfg.xml than no need to give explicitly name in configurate() else give).
7.  Add the annotated class to the Configuration object.
8.  Build the SessionFactory object.
9.  Use the SessionFactory object to create a Session object.
10. Begin a transaction using the Session object.(not required for read operations)
11. Perform database operations (e.g., save, update, delete, get).
12. Commit the transaction.
13. Close the Session object.
14. Close the SessionFactory object.
15. Run the application and check the database for changes.
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
### Reading Entities
Use session.get() to fetch an entity by its primary key. If the entity doesn't exist, get() returns null it is eager loading.

```java
 import org.hibernate.Session;

SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
Session session = sessionFactory.openSession();
Student student = session.get(Student.class, studentId);
```
Lazy loading
Use session.load()(for hibernate 5) and session.getReference() (hibernate 6) to fetch an entity lazily. If the entity doesn't exist, load() throws an exception.
Note : These 1st create an proxy object and when we call any method on it then it will hit the database. while get just create the object and hit the database.

```java
SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
Session session = sessionFactory.openSession();
Student student = session.getReference(Student.class, studentId);
Student student = session.load(Student.class, studentId);
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
# All Annotation for hibernate and explanation

1. `@Entity`: Marks a class as an entity, representing a table in a relational database.
2. `@Table`: Specifies the table name for the entity. Defaults to the class name if not specified.
3. `@Id`: Marks a field as the primary key of the entity.
4. `@GeneratedValue`: Specifies the generation strategy for the primary key. Options include `IDENTITY`, `AUTO`, `SEQUENCE`, and `TABLE`.
5. `@Column`: Specifies the column name for a field. Defaults to the field name if not specified.
6. `@Transient`: Marks a field as transient, meaning it's not persisted to the database.
7. `@OneToMany`: Defines a one-to-many relationship between two entities.
8. `@ManyToOne`: Defines a many-to-one relationship between two entities.
9. `@JoinColumn`: Specifies the foreign key column in a relationship.
10. `@JoinTable`: Specifies the join table for a many-to-many relationship.
11. `@NamedQuery`: Defines a named query for an entity.
12. `@NamedQueries`: Defines multiple named queries for an entity.
13. `@Temporal`: Specifies the temporal type for a date field (`DATE`, `TIME`, `TIMESTAMP`).
14. `@Basic`: Specifies the fetch type for a field (`LAZY`, `EAGER`).
15. `@Version`: Marks a field as the version number for optimistic locking.
16. `@SequenceGenerator`: Specifies a sequence generator for the primary key.
17. `@TableGenerator`: Specifies a table generator for the primary key.
18. `@Inheritance`: Specifies the inheritance strategy for an entity (`SINGLE_TABLE`, `JOINED`, `TABLE_PER_CLASS`).
19. `@DiscriminatorColumn`: Specifies the discriminator column for inheritance.
20. `@DiscriminatorValue`: Specifies the value for the discriminator column.
21. `@Embedded`: Embeds an object into an entity.
22. `@Embeddable`: Marks a class as embeddable.
23. `@ElementCollection`: Maps a collection of basic types or embeddable objects.
24. `@CollectionTable`: Specifies the table for an element collection.
25. `@ManyToMany`: Defines a many-to-many relationship between two entities.
26. `@OneToOne`: Defines a one-to-one relationship between two entities.

## Cache in Hibernate
Hibernate provides a caching mechanism to improve performance by reducing the number of database queries. There are two types of caching in Hibernate:

1. First-level cache: It's associated with the Session object and is enabled by default. It's used to reduce the number of SQL queries by storing objects in memory.
2. Second-level cache: It's shared across multiple sessions and is used to cache objects across transactions. It's not enabled by default and requires a cache provider like Ehcache or Infinispan.
3. Query cache: It's used to cache query results and is enabled by setting the `hibernate.cache.use_query_cache` property to true.
