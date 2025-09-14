package com.subham.java_config.service;

import com.subham.java_config.model.Student;

import java.util.List;

public interface StudentDao {

     void insert(Student student);

     void updateDetails(Student student);

     void delete(int id);

     Student getStudentById(int id);

     List<Student> getAllStudent();
}
