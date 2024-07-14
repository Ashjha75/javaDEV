package org.ashish.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentTable") //not required if table name is same as class name
public class Student {

    @Id //primary key
    @Column(name = "studentId") //not required if column name is same as field name
    private int studentId;

    private String studentName;
    private String studentAddress;
    private String studentEmail;

//    make a zero argument constructor for the hibernate to work


    public Student() {
        System.out.println("Student object created for hibernate");
    }

    public int getStudentId() {
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

    public void setStudentId(int studentId) {
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
