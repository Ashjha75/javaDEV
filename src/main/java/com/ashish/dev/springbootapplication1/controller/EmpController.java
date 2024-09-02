package com.ashish.dev.springbootapplication1.controller;

import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmpController {

    @GetMapping("employees")
    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeModel> employees =new ArrayList<EmployeeModel>();
        EmployeeModel employee=new EmployeeModel();
        employee.setName("Ashish");
        employee.setId(1L);
        employee.setDepartment("IT");
        employee.setSalary(10000);
        employee.setEmail("ajha5645@gmail.com");
        employee.setAge(25);
        employee.setPhoneNumber(1234567890);
        employees.add(employee);
        return employees;
    }
}
