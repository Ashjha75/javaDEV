package com.ashish.dev.springbootapplication1.controller;

import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {
    List<EmployeeModel> employees =new ArrayList<EmployeeModel>();
    @GetMapping("employees")
    public List<EmployeeModel> getAllEmployees() {
        return employees;
    }

    @PostMapping("employees")
    public String CreateEmployee(@RequestBody EmployeeModel employee){
        employees.add(employee);
        return "Employee added successfully";
    }
}
