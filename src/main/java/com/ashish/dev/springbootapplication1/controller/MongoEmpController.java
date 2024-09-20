package com.ashish.dev.springbootapplication1.controller;


import com.ashish.dev.springbootapplication1.model.MongoEmplModel;
import com.ashish.dev.springbootapplication1.service.MongoEmplServices;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoEmpController {

    @Autowired
    private MongoEmplServices MongoEmplServices;


    @PostMapping("employees")
    public String createEmployee(@RequestBody MongoEmplModel employee) {
        return MongoEmplServices.createEmployee(employee);
    }

    @GetMapping("employees")
    public List<MongoEmplModel> getAllEmployees() {
        return MongoEmplServices.readEmployees();
    }

    @PutMapping("employees")
    public String updateEmployee(@RequestBody MongoEmplModel employee) {
        System.out.println("Employee: " + employee);
        if (MongoEmplServices.updateEmployee(employee)) {
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }


    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable ObjectId id) {
        if (MongoEmplServices.deleteEmployee(id)) {
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<MongoEmplModel> getEmployeeById(@PathVariable ObjectId id) {
        return MongoEmplServices.getEmployeeById(id);
    }


}
