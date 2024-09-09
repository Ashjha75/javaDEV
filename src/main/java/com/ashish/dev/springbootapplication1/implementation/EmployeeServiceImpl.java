// EmployeeServiceImpl.java
package com.ashish.dev.springbootapplication1.service.impl;

import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import com.ashish.dev.springbootapplication1.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<EmployeeModel> employees = new ArrayList<>();

    @Override
    public List<EmployeeModel> readEmployees() {
        return employees;
    }

    @Override
    public String createEmployee(EmployeeModel employee) {
        employees.add(employee);
        return "Employee added successfully";
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employees.removeIf(employee -> employee.getId() == id);
    }

    @Override
    public boolean updateEmployee(EmployeeModel employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                return true;
            }
        }
        return false;
    }
}