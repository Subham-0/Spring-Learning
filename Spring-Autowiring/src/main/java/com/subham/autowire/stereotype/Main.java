package com.subham.autowire.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotype_config.xml");
        Student student = context.getBean("st", Student.class);
        System.out.println(student);
    }
}
