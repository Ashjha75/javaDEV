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

> 💡 **Note:** We can also configure Hibernate directly in Java configuration using `config.setProperty(propertyName, value)` and also we can use a `hibernate.properties` file for that.

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

###  L1 Cache Explanation  
- This level of cache is created implicitly for every object for that session therefore for same request hibernate will not write the query again and again.
- Hibernate will always check the L1 cache 1st than it will execute any query if there is any change in query then the new object will reside in L1 Cache not previous one.

### L2 Cache Explanation
- This level of cache is created for the whole application, and it is shared across multiple sessions.
- It is not enabled by default, and we have to enable it by using some cache provider like Ehcache or Infinispan.
- It is used to cache objects across transactions.
- It is used to reduce the number of database queries.

# Hibernate Associate mapping:
1. One to One Mapping in Hibernate
2. One to Many Mapping in Hibernate
3. Many to One Mapping in Hibernate
4. Many to Many Mapping in Hibernate

## One to One Mapping in Hibernate
In one-to-one mapping, one entity is associated with another entity. 
For example, a student can have only one address, and an address can be associated with only one student.
This mapping can be done using the `@OneToOne` annotation and specifying the `cascade` type.

Below example is for one to one mapping in hibernate:

**Question Model**
```java
package org.ashish.model;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String questionText;

    @OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
    private Answers answer;
}
```
**Answer Model**
```java
package org.ashish.model;

import jakarta.persistence.*;

@Entity
@Table(name = "answers")
public class Answers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answerText;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructors, getters, and setters
}
```
**Main Class**
```java
Configuration configuration = new Configuration().configure();
try (SessionFactory sessionFactory = configuration.buildSessionFactory();
     Session session = sessionFactory.openSession()) {
    Transaction transaction = session.beginTransaction();

    Question question = new Question("What is Java?");
    Answers answer = new Answers("Java is a programming language");

    question.setAnswer(answer);
    answer.setQuestion(question);

    session.persist(question);
    transaction.commit();
}
```
## One to Many Mapping in Hibernate
In one-to-many mapping, one entity is associated with multiple entities.
For example, a department can have multiple employees, but an employee can belong to only one department.
This mapping can be done using the `@OneToMany` annotation and specifying the `mappedBy` attribute.

Below example is for one to many mapping in hibernate:
```java
package org.ashish.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Constructors, getters, and setters
}
```
```java
package org.ashish.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Constructors, getters, and setters
}
```
```java
Configuration configuration = new Configuration().configure();
try (SessionFactory sessionFactory = configuration.buildSessionFactory();
     Session session = sessionFactory.openSession()) {
    Transaction transaction = session.beginTransaction();

    Department department = new Department("IT");
    Employee employee1 = new Employee("John Doe");
    Employee employee2 = new Employee("Jane Smith");

    department.setEmployees(Arrays.asList(employee1, employee2));
    employee1.setDepartment(department);
    employee2.setDepartment(department);

    session.persist(department);
    transaction.commit();
}
```

## Many to One Mapping in Hibernate
In many-to-one mapping, multiple entities are associated with one entity.
For example, multiple employees can belong to one department, but a department can have multiple employees.
This mapping can be done using the `@ManyToOne` annotation and specifying the `@JoinColumn` attribute.  

Example is above in one to many mapping.

## Many to Many Mapping in Hibernate
In many-to-many mapping, multiple entities are associated with multiple entities.
For example, multiple students can enroll in multiple courses, and multiple courses can have multiple students.
This mapping can be done using the `@ManyToMany` annotation and specifying the `@JoinTable` attribute.

Below example is for many to many mapping in hibernate:
```java
package org.ashish.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    // Constructors, getters, and setters
}
```
```java
package org.ashish.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;

    // Constructors, getters, and setters
}
```
```java
Configuration configuration = new Configuration().configure();
try (SessionFactory sessionFactory = configuration.buildSessionFactory();
     Session session = sessionFactory.openSession()) {
    Transaction transaction = session.beginTransaction();

    Student student1 = new Student("John Doe");
    Student student2 = new Student("Jane Smith");

    Course course1 = new Course("Java Programming");
    Course course2 = new Course("Database Management");

    student1.setCourses(Arrays.asList(course1, course2));
    student2.setCourses(Arrays.asList(course1));

    course1.setStudents(Arrays.asList(student1, student2));
    course2.setStudents(Arrays.asList(student1));

    session.persist(student1);
    session.persist(student2);
    transaction.commit();
}
```
#  (JPQL) 
JPQL Stands for Java Persistence Query Language. It is used to write queries to perform CRUD operations on entities. It is similar to SQL but operates on objects and their properties instead of tables and columns.
This is an abstraction or Specification of SQL queries. 
HQL is one of the implementation of JPQL.

# Hibernate Query Language (HQL)/(JPQL)
Hibernate Query Language (HQL) is a powerful query language similar to SQL but operates on objects and their properties instead of tables and columns.
The main advantage of Hql over normal sql query is that this is same for all type of sal vendor because we are dealing with entity and their properties not with table and columns directly.

Some examples are:

```genericsql
sql> INSERT INTO emp (emp_id, emp_name, emp_salary) VALUES (1, 'John Doe', 50000);
hql> INSERT INTO Employee (empId, empName, empSalary) VALUES (1, 'John Doe', 50000);

sql> SELECT * FROM emp WHERE emp_id > 1 AND emp_id < 10;
hql> FROM Employee WHERE empId > 1 AND empId < 10;
   
sql> UPDATE emp SET emp_salary = 60000 WHERE emp_id = 1;
hql> UPDATE Employee SET empSalary = 60000 WHERE empId = 1;

sql> DELETE FROM emp WHERE emp_id = 1;
hql> DELETE FROM Employee WHERE empId = 1;
```










