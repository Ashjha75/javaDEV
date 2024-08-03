package com.ashish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
//component annotation is used to create object of this class in the spring container
@Component
public class Alien {
//    Setter Injection-------------------------

    private int age;

//    for reference variable laptop
    @Autowired
    @Qualifier("desktop")
    private Computer computer;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code() {
        System.out.println("Hello from Alien class");
    }

//    Constructor Injection-------------------------
//    private int age;
//    private Laptop laptop;
//
//    public Alien() {
//        System.out.println("Alien object created");
//    }
//
//    public Alien(int age) {
//        this.age = age;
//    }
//
//    public Alien(Laptop laptop) {
//        this.laptop = laptop;
//    }
//
//    public Alien(int age, Laptop laptop) {
//        this.age = age;
//        this.laptop = laptop;
//    }
//
//    public void code() {
//        System.out.println("Hello from Alien class");
//        laptop.compile();
//    }


//    Using Interface for Laptop
//    private int age;
//    private Computer computer;
//
//    public Alien() {
//        System.out.println("Alien object created");
//    }
//
//    public Alien(int age) {
//        this.age = age;
//    }
//
//    public Alien(Computer computer) {
//        this.computer = computer;
//    }
//
//    public Alien(int age, Computer computer) {
//        this.age = age;
//        this.computer = computer;
//    }
//
//    public void code() {
//        System.out.println("Hello from Alien class");
//        computer.compile();
//    }

}
