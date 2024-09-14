package com.ashish.dev.springbootapplication1.model;

import lombok.Data;

@Data
public class EmployeeModel {
    private Long id;
    private String name;
    private String department;
    private double salary;
    private String email;
    private int age;
    private String phoneNumber;
}