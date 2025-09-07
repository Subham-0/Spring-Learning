package com.subham.collection;

import com.subham.primitive.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("collection_config.xml");

        Teacher s3 = context.getBean("tech1", Teacher.class);
        System.out.println(s3);
    }
}
