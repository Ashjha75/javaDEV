package com.ashish.repositiories;

import com.ashish.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Student student) {
        if (existsByRollNo(student.getRollNo())) {
            update(student);
        } else {
            insert(student);
        }
    }

    private void insert(Student student) {
        String query = "INSERT INTO student (rollNo, name, marks) VALUES (?, ?, ?)";
        jdbc.update(query, student.getRollNo(), student.getName(), student.getMarks());
    }

    private void update(Student student) {
        String query = "UPDATE student SET name = ?, marks = ? WHERE rollNo = ?";
        jdbc.update(query, student.getName(), student.getMarks(), student.getRollNo());
    }

    private boolean existsByRollNo(int rollNo) {
        String query = "SELECT COUNT(*) FROM student WHERE rollNo = ?";
        Integer count = jdbc.queryForObject(query, Integer.class, rollNo);
        return count != null && count > 0;
    }

    public List<Student> findAll() {
        String query = "SELECT * FROM student";

        return jdbc.query(query, (ResultSet resultSet, int i) -> {
            Student student = new Student();
            student.setRollNo(resultSet.getInt("rollNo"));
            student.setName(resultSet.getString("name"));
            student.setMarks(resultSet.getInt("marks"));
            return student;
        });
    }
}