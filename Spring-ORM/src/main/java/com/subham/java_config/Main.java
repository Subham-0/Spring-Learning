package com.subham.java_config;

import com.subham.java_config.service.StudentService;
import com.subham.java_config.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(OrmConfig.class);
        StudentService studentService = context.getBean(StudentService.class);
        Student s = new Student();
        s.setId(108);
        s.setName("Raja");
        s.setAddress("charigan");
        studentService.saveStudent(s);


    }
}
