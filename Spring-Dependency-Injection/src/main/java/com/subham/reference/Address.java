package com.subham.reference;

import com.subham.collection.Teacher;
import com.subham.primitive.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Address {
    private String city;
    private List<Subject> subjects;
    private List<Teacher> teacherList;
    private List<Student> studentList;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public String toString() {
        int count = 0;
        return "Address{" +
                "city='" + city + '\''  +
                ", subjects=" + subjects.stream().map(Subject::getName).collect(Collectors.toList()) +
                ", teachers=" + teacherList.stream().map(Teacher::getName).collect(Collectors.toList()) +
                ", no_of_students=" + (studentList != null ? studentList.size() : 0) +
                '}';
    }
}
