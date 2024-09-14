package com.ashish.dev.springbootapplication1.controller;

import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import com.ashish.dev.springbootapplication1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("employees")
    public List<EmployeeModel> getAllEmployees() {
        return employeeService.readEmployees();
    }

    @PostMapping("employees")
    public String createEmployee(@RequestBody EmployeeModel employee) {
        employeeService.createEmployee(employee);
        return "Employee added successfully";
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        if (employeeService.deleteEmployee(id)) {
            return "Employee deleted successfully";
        } else {
            return "Employee not found";
        }
    }

    @PutMapping("employees")
    public String updateEmployee(@RequestBody EmployeeModel employee) {
        if (employeeService.updateEmployee(employee)) {
            return "Employee updated successfully";
        } else {
            return "Employee not found";
        }
    }
}