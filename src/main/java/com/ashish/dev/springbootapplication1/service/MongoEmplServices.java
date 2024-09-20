package com.ashish.dev.springbootapplication1.service;


import com.ashish.dev.springbootapplication1.model.MongoEmplModel;
import org.bson.types.ObjectId;
import org.jvnet.hk2.annotations.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public interface MongoEmplServices {
    List<MongoEmplModel> readEmployees();
    String createEmployee(MongoEmplModel employee);
    boolean updateEmployee(MongoEmplModel employee);
    boolean deleteEmployee(ObjectId id);
    ResponseEntity<MongoEmplModel> getEmployeeById(ObjectId id);
}
