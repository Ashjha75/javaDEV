// EmployeeServiceImpl.java
package com.ashish.dev.springbootapplication1.implementation;

import com.ashish.dev.springbootapplication1.model.EmployeeModel;
import com.ashish.dev.springbootapplication1.service.EmployeeService;
import com.ashish.dev.springbootapplication1.entity.EmployeeEntity;
import com.ashish.dev.springbootapplication1.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeModel> readEmployees() {
        logger.info("Fetching all employees from the database");
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<EmployeeModel> employees = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeModel employee = new EmployeeModel();
            BeanUtils.copyProperties(employeeEntity, employee);
            employees.add(employee);
        }
        logger.info("Fetched {} employees", employees.size());
        return employees;
    }

    @Override
    public String createEmployee(EmployeeModel employee) {
        logger.info("Creating a new employee with name: {}", employee.getName());
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);
        logger.info("Employee created successfully with ID: {}", employeeEntity.getId());
        return "Employee added successfully";
    }

    @Override
    public EmployeeModel readEmployee(Long id) {
        logger.info("Fetching employee with ID: {}", id);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            EmployeeModel employeeModel = new EmployeeModel();
            BeanUtils.copyProperties(employeeEntity.get(), employeeModel);
            logger.info("Employee fetched successfully");
            return employeeModel;
        }
        logger.warn("Employee with ID: {} not found", id);
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        logger.info("Deleting employee with ID: {}", id);
        Optional<EmployeeEntity> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            employeeRepository.delete(emp.get());
            logger.info("Employee deleted successfully");
            return true;
        }
        logger.warn("Employee with ID: {} not found", id);
        return false;
    }

    @Override
public boolean updateEmployee(EmployeeModel employee) {
    logger.info("Updating employee with ID: {}", employee.getId());
    try {
        if (employeeRepository.existsById(employee.getId())) {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            BeanUtils.copyProperties(employee, employeeEntity);
            employeeRepository.save(employeeEntity);
            logger.info("Employee updated successfully");
            return true;
        } else {
            logger.warn("Employee with ID: {} not found", employee.getId());
            return false;
        }
    } catch (Exception e) {
        logger.error("Error updating employee with ID: {}", employee.getId(), e);
        return false;
    }
}
}