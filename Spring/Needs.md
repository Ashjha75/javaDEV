# IOC

1st  We will know why the Previous way of [Strategy Pattern](SomeBasics.md#strategy-pattern):
Lets take an example of cars, so we will make a classes following Strategy Pattern.
```Java
interface iCarProducer {
    void drive();
}
```
```java
class Sedan implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Sedan");
    }
}
```
```java
class SUV implements Car {
    @Override
    public void drive() {
        System.out.println("Driving SUV");
    }
}
```
```java
class carDriver {
    private iCarProducer carProducer;
    
    public driveCar(String instruction){
        carProducer=new SUV();
        carProducer.drive();
    }
}
```
Now above , Even if we followed the recommended design principals, mainly it has two Problems:
1. In carDriver class, we are hardCoding the  SUV object means whenever we need to change this to Sedan we need to change the source code of the carDriver class.
2. We should note that here carDriver is  creating the object of either Sedan or SUV, so for this it needs to know the complete instantiation process of creating the object.
   * Like some objects can be creating using new keyword. However, some objects have dependencies on other objects,like class A may have dependent on class B
     but surprisingly class B is 
   dependent on another class C,
     so in this case we need to know the complete instantiation process of creating the object.