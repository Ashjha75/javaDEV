package com.ashish;

public class Alien {
//    Setter Injection-------------------------

//    private int age;
//
////    for reference variable laptop
//    private Laptop laptop;
//
//    public Laptop getLaptop() {
//        return laptop;
//    }
//
//    public void setLaptop(Laptop laptop) {
//        System.out.println("setLaptop method called");
//        this.laptop = laptop;
//    }
//
//    public int getAge() {
//        System.out.println("getAge method called");
//        return age;
//    }
//
//    public void setAge(int age) {
//        System.out.println("setAge method called");
//        this.age = age;
//    }
//
//    public static void main(String[] args) {
//        System.out.println("object created");
//    }
//
//
//    public void code() {
//        System.out.println("Hello from Alien class");
//    }

//    Constructor Injection-------------------------
    private int age;
    private Laptop laptop;

    public Alien() {
        System.out.println("Alien object created");
    }

    public Alien(int age) {
        this.age = age;
    }

    public Alien(Laptop laptop) {
        this.laptop = laptop;
    }

    public Alien(int age, Laptop laptop) {
        this.age = age;
        this.laptop = laptop;
    }

    public void code() {
        System.out.println("Hello from Alien class");
        laptop.compile();
    }

}
