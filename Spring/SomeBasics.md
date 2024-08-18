# Some Basics Concept of spring core

spring core is the basic of spring framework means it is horizontally scaled to all type of other module because spring
is divided into many modules::

- `spring core `
- `spring aop`
- `spring jdbc`
- `spring orm` etc... \
  but here main point is that Spring is very lightweight and loosely coupled framework.
  Means lets say if I have to work on persistence application than spring is modular enough that I just need to implement
  `Spring core + Spring ORM` module and I am good to go. This is the real meaning of loosely coupled framework.
  Its have all feature of heavyweight framework like EJB, but it is very lightweight and easy to use because of its
  modular nature.

# Spring core (basics):

`` Note : In an application we will have multiple classes ; all the classes will not play the same role .
Few Classes are called Java Beans,Pojo(Plain Old Java Object) and some are called Component or Beans classes.
``

- `Java Beans` : these class not contain any business logic, and they are used to store the data using getter and setter.
- `Pojo` : If any class that can be executed directly by Jdk without the need of 3rd party library is called Pojo.
- `Component` : These classes are used to store the business logic, and they are called beans because they are managed by
  spring container.

# Strategy Pattern:

1. Favor composition over inheritance.
2. Always design to Interfaces never code to Implementation .
3. Code should be open for extension but closed for modification.

# Favor composition over inheritance:

Every class in order to perform tasks has to talk with other class to get the work done.

1. Through Inheritance - Inheritance is the process of extending one class from another class to get its
   functionalities.
2. Through Composition - A Class will hold reference of other class as attribute inside it.

Using Inheritance is not a good practice because it is tightly coupled and if we change the parent class then all the
child class will be affected.\
Relationship between two classes are

- `IS-A` : Inheritance              (Tightly Coupled)
- `HAS-A` : Composition             (Loosely Coupled)

We should only go for `Inheritance` When we need all the behaviour of parent class in child class.
If we need little behaviour of parent class in child class then we should go for `Composition`.

- `Composition vs. inheritance`: Most use cases can be solved through composition rather than inheritance, and use of
  composition is recommended when all services are not required.

- `Multiple class use`: When a class wants to use multiple class features, choosing inheritance can cause problems in
  programming languages where multiple inheritance is not supported.

- `Frushed/Fragile  class`: When using inheritance, the class gets complicated and can be easily broken(fragile), which
  can cause
  maintenance difficulties.

- `Alternatives to composition`: Therefore, it is safer and more effective to use the composition when it requires
  multi-class functionality.

example of why we should use composition over inheritance::

- Let's say we have class `A` and class `B` and class `A` is class in which one behaviour is present called
  method `m1()`
  so when using inheritance we inherit method `m1()` in class `B` it can be done easily.
- Here , we should note that both the Classes are designed by two different Developers .
- Now, let's say the Developer of class `A` wants to change the return type of method `m1()` from `int` to `Float` . Now
  all the child class whose
  parent is class `A` will be affected will have to change the return type of method `m1()` from `int` to `Float` .
  example::

```java
class A {
    public int m1() {
        return 10;
    }
}
```

```Java
class B extends A {
    public int m1() {
        return 20;
    }
}

```

if int is converted to float in class `A` then class `B` will also have to change the return type of method `m1()`
from `int` to `Float` .

```java
class A {
    public Float m1() {
        return 10.0f;
    }
}
```

```Java
class B extends A {
    public Float m1() {
        return 20.0f;
    }
}
```

But here `Composition` comes into picture, and it is the best way to solve this problem because in composition we can use
the object of class `A` in class `B` and we can call the method `m1()` of class `A` in class `B` and if the return type
of
method `m1()` is changed in class `A` then it will not affect the class `B` because class `B` is using the object of
class, so we can directly
typecast the method `m1()` of class `A` in class `B` and it will not affect the class `B` .

```java
class A {
    public int m1() {
        return 10;
    }
}
```

```Java
class B {
    A a = new A();

    @Override
    public int m1() {
        return a.m1();
    }
}
```

if int is converted to float in class `A` then class `B` will not have to change the return type of method `m1()`
from `int` to `Float` .

```java
class A {
    public Float m1() {
        return 10.0f;
    }
}
```

```Java
class B {
    A a = new A();

    @Override
    public Float m1() {
        return a.m1();
    }
}
```

| Aspect                  | Inheritance                                                                                  | Composition                                                                                      |
|-------------------------|----------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------|
| Coupling                | Tightly coupled                                                                              | Loosely coupled                                                                                  |
| Flexibility             | Less flexible, changes in parent affect all children                                         | More flexible, changes in one class do not affect others                                         |
| Reusability             | Limited to single inheritance (in languages that do not support multiple inheritance)        | Can reuse multiple classes by including their instances                                          |
| Maintenance             | Harder to maintain, changes in parent class can break child classes                          | Easier to maintain, changes in one class do not affect others                                    |
| Design Principle        | IS-A relationship                                                                            | HAS-A relationship                                                                               |
| Use Case                | Use when child class needs all behavior of parent class                                      | Use when child class needs only some behavior of another class                                   |
| Example                 | `class B extends A {}`                                                                       | `class B { A a = new A(); }`                                                                     |
| Impact of Changes       | Changes in parent class require changes in all child classes                                 | Changes in one class do not require changes in other classes                                     |
| Complexity              | Can lead to fragile base class problem                                                       | Reduces complexity by promoting modular design                                                   |
| Multiple Class Features | Not suitable for using features from multiple classes                                        | Suitable for using features from multiple classes                                                |
| Testing                 | Testing is not easy will have to use dummy class(engine ,bus) if there  is no implementation | Testing is easy because we can test as many as data without creating a static reference of class |


# Always design to Interface, never code to Implementation:
This means the whenever we write any logic in our code it should always be written in terms of Interface and not in
terms of Implementation of code so that we can easily change the implementation of code without changing the code.
Example::
1. Define an interface `Vehicle` with a method `startEngine()`.
2. Create two classes `Car` and `Bike` that implement the `Vehicle` interface.
3. Demonstrate how to use the `Vehicle` interface in a client class without depending on the concrete implementations.

```java
interface Vehicle {
    void startEngine();
}
```
```java
class Car implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Car engine started");
    }
}
```
```java
class Bike implements Vehicle {
    @Override
    public void startEngine() {
        System.out.println("Bike engine started");
    }
}
```
```java
class Client {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.startEngine();
        vehicle = new Bike();
        vehicle.startEngine();
    }
}
```
now this is totally dependent on interface no on the logic of implementation of startEngine() method.
So in future if I want to make the Truck class and I want to implement the Vehicle interface then I can easily do that.

# Code should be open for extension but closed for modification:
This means that the code should be written in such a way that it should be open for extension but closed for
modification.\
Example::
Now let's say we have a same example of `Vehicle` interface and `Car` and `Bike` classes and  now a new type of engine came 
into the market called `ElectricEngine` and we want to implement this engine in our code then we can easily do that by
implementing the `ElectricEngine` class, and we can use the `ElectricEngine` class in our code without changing the
code of `Vehicle` interface and `Car` and `Bike` classes.

# Spring Inversion of Control (IoC):
Inversion of Control (IoC) is a design principle in which the control of objects creation and lifecycle is transferred
to a container or framework.\

> 📌 **Note:** To know more about the need of `IOC` and why the above methods fails - [Link to IOC Need](Needs.md#ioc)

IoC is a design principle where an object's dependencies are provided externally by a container, rather than the object creating or locating these dependencies itself. In Spring, dependencies are injected via constructor arguments, factory methods, or properties after object creation. This approach reverses the traditional control flow, where the object would typically manage its dependencies directly.

**Key Point** : The key advantage of IoC is that it allows objects to declare their dependencies without managing them directly, promoting better separation of concerns and making code more modular and testable.

### Types of IOC
1. Dependency lookup
    * Dependency Pull
    * Contextual Dependency Lookup
2. Dependency Injection
    * Setter Injection
    * Constructor Injection

## Dependency Lookup
Old way of getting the dependencies from the container. In this technic if a class needs another dependent 
object; it will ask or write the code for getting the dependency .

#### 1) Dependency Pull
Dependency Pull refers to a method where an object explicitly retrieves its dependencies from the Spring container rather than having them injected automatically.
eg. fetching connection pull from the container.
#### 2) Contextual Dependency Lookup
Contextual Dependency Lookup refers to a method where an object retrieves its dependencies based on the context in which it is created. This allows for more fine-grained control over the dependencies that are retrieved.
In this both are agreed on single concept/Context.
eg. servelet config will be injected in servelet context by the container.

##  Dependency Injection
Dependency Injection is a design pattern where an object's dependencies are provided to it by an external entity, rather than the object creating or locating its dependencies itself.

#### 1) Setter Injection
Setter Injection involves providing dependencies through setter methods after the object has been instantiated. This method allows the object to be created first and then its dependencies to be injected.

#### 2) Constructor Injection
Constructor Injection involves passing dependencies to a class through its constructor. When a Spring container creates an instance of the class, it invokes the constructor with the required dependencies.

When we create a `BeanFactory object` classPathResource will look for the application-context.xml under the class path of ouur
project and loads and gives it as an input XmlBeanFactory will take the xml and performs well-formed validation, once it is well-formed it will place the Xml into Jvm memory.
This loaction where the spring beans object and its metadata is placed is called core container or ioc container.
Ioc container is just a logical memory partition in which our spring beans will be maintained.(Similar to hashmap data structure)

The  Xml will be placed as in-memory metadata in the ioc container and gives the reference of BeanFactory object to us. 
When we call factory.getBean("beanName"), then the BeanFactory goes into its in-memory metadata of the IOC container search for the BeanFactory goes into its
in-memory metadata of the IOC container search for the bean reference with that id. If found it will
create the object of the class by calling new Operator and place the object in the Ioc container with the given id and return the reference of the object to us.

## Constructor Vs Setter Injection

| Constructor Injection                                                                                                                     | Setter Injection                                                                                                  |
|-------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------|
| At the time of creating your target class object, the dependent objects are injected (can be accessed in the constructor of target class) | After creating the target class object, the dependent objects are injected (can be accessed using setter methods) |
| Here all the dependent objects are mandatory to be injected. otherwise `BeanCreationException` will be thrown                             | Here there is no need of all the dependent objects; they are all optional                                         |
| If classes have cyclic dependency via constructor, these dependent beans cannot be configured through Constructor Injection.              | Cyclic Dependencies are allowed here                                                                              |



