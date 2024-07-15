package org.ashish.model;


import jakarta.persistence.*;

import org.ashish.utils.alphanumericPrimaryKeygenerator;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "studentTable") //not required if table name is same as class name
public class Student {

    @Id //primary key
    @GeneratedValue(generator = "alphanumericPrimaryKeygenerator")
    @GenericGenerator(name="alphanumericPrimaryKeygenerator", strategy = "org.ashish.utils.alphanumericPrimaryKeygenerator")
    @Column(name = "studentId", unique = true, nullable = false, updatable = false)
    private String studentId;

    private String studentName;
    private String studentAddress;
    private String studentEmail;

//    make a zero argument constructor for the hibernate to work


    public Student() {
        System.out.println("Student object created for hibernate");
    }

    public String getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String toString() {
        return "Student {" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
