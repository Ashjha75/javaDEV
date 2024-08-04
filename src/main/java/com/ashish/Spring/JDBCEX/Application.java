package com.ashish.Spring.JDBCEX;

import com.ashish.models.Student;
import com.ashish.services.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.ashish")
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);

        Student student = context.getBean(Student.class);
        student.setRollNo(1);
        student.setName("Ashish");
        student.setMarks(100);

        StudentService studentService = context.getBean(StudentService.class);
        System.out.println("Student object created: " + student);
        studentService.addStudent(student);

        List<Student> students = studentService.getStudents();
        System.out.println("Students: " + students);
    }
}