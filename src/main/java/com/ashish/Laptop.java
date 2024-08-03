package com.ashish;

public class Laptop implements Computer {

    @Override
    public void compile() {
        System.out.println("Compiling from Laptop");
    }
}
