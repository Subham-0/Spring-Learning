package com.subham.java_config;

import com.subham.java_config.service.StudentDao;
import com.subham.java_config.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrmConfig.class);
        StudentDao studentDao = context.getBean("studDao", StudentDao.class);
        Student s = new Student();
        s.setId(108);
        s.setName("Rahul");
        s.setAddress("Polasahi");
        studentDao.insert(s);
//        studentDao.updateDetails(s);
//        studentDao.delete(108);
//        Student st = studentDao.getStudentById(105);
//        System.out.println(st);
//        List<Student> studentList = studentDao.getAllStudent();
//        studentList.forEach(System.out::println);
    }
}
