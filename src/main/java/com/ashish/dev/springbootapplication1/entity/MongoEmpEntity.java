package com.ashish.dev.springbootapplication1.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class MongoEmpEntity {
    @Id
    private ObjectId _id;
    private String name;
    private String department;
    private double salary;
    private String email;
    private int age;
    private String phoneNumber;
}