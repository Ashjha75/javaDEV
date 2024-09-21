package com.ashish.dev.springbootapplication1.model;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class MongoEmplModel {
    private ObjectId _id;
    private String name;
    private String department;
    private double salary;
    private String email;
    private int age;
    private String phoneNumber;
}
