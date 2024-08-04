package com.ashish.services;

import com.ashish.models.Student;
import com.ashish.repositiories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {
    private StudentRepo studentRepo;

    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    @Autowired
    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void addStudent(Student student) {
        System.out.println("In Service -----------------");
        studentRepo.save(student);
    }

    public List<Student> getStudents() {
        return studentRepo.findAll();
    }
}
