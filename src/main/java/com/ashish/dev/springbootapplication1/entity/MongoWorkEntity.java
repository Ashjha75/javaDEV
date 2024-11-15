package com.ashish.dev.springbootapplication1.entity;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "mongoWork")
public class MongoWorkEntity {

    @org.springframework.data.annotation.Id
    private ObjectId _id = new ObjectId();

    @Indexed(unique = true)
    @NotBlank(message = "Title is mandatory")
    private String title;

    private String department;
    private String tag;

    @NotBlank(message = "Status is mandatory")
    private String status;


    private Date targetDate;

    @DBRef
    private List<EmployeeEntity> employees;
}