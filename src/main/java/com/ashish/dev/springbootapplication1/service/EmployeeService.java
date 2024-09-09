package com.ashish.dev.springbootapplication1.service;


import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface EmployeeService {
    String createEmployee(EmployeeModel employee);
    List<EmployeeModel> readEmployees();
    boolean updateEmployee(EmployeeModel employee);
    boolean deleteEmployee(int id);
}
