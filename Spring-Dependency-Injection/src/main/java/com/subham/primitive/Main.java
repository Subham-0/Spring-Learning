package com.subham.primitive;

import com.subham.collection.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("primitive_config.xml");

        Student s1 = context.getBean("stud1", Student.class);
        System.out.println(s1);
        Student s2 = context.getBean("stud2", Student.class);
        System.out.println(s2);

    }
}
