package com.ashish.dev.springbootapplication1.implementation;

import com.ashish.dev.springbootapplication1.entity.MongoEmpEntity;
import com.ashish.dev.springbootapplication1.model.MongoEmplModel;
import com.ashish.dev.springbootapplication1.repository.MongoEmployRepository;
import com.ashish.dev.springbootapplication1.service.MongoEmplServices;
import com.ashish.dev.springbootapplication1.utility.exception;
import org.bson.types.ObjectId;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MongoEmplServiceImpl implements MongoEmplServices {

    @Autowired
    private MongoEmployRepository mongoEmployRepository;

    @Override
    public List<MongoEmplModel> readEmployees() {
        List<MongoEmpEntity> employeeEntities = mongoEmployRepository.findAll();
        return employeeEntities.stream()
                .map(employeeEntity -> {
                    MongoEmplModel employee = new MongoEmplModel();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                })
                .collect(Collectors.toList());
    }

    @Override
    public String createEmployee(MongoEmplModel employee) {
        MongoEmpEntity employeeEntity = new MongoEmpEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        mongoEmployRepository.save(employeeEntity);
        return "Employee added successfully";
    }

    @Override
    public boolean updateEmployee(MongoEmplModel employee) {
        if (employee.get_id() == null || !mongoEmployRepository.existsById(employee.get_id())) {
            return false;
        }

        MongoEmpEntity existingEmployee = mongoEmployRepository.findById(employee.get_id()).orElse(null);
        if (existingEmployee == null) {
            return false;
        }

        // Update only the fields that are provided
        if (employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }
        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }
        if (employee.getSalary() != 0) {
            existingEmployee.setSalary(employee.getSalary());
        }
        if (employee.getEmail() != null) {
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getAge() != 0) {
            existingEmployee.setAge(employee.getAge());
        }
        if (employee.getPhoneNumber() != null) {
            existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        }

        mongoEmployRepository.save(existingEmployee);
        return true;
    }

    @Override
    public boolean deleteEmployee(ObjectId id) {

        if (mongoEmployRepository.existsById(id)) {
            mongoEmployRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

 @Override
public ResponseEntity<MongoEmplModel> getEmployeeById(ObjectId id) {
    try {
        if (id == null) {
            return ResponseEntity.badRequest().body(null);
        }

        MongoEmpEntity employeeEntity = mongoEmployRepository.findById(id)
                .orElseThrow(() -> new exception("Employee not found with ID: " + id));

        MongoEmplModel employeeModel = new MongoEmplModel();
        BeanUtils.copyProperties(employeeEntity, employeeModel);
        return ResponseEntity.ok(employeeModel);
    } catch (exception e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
}
