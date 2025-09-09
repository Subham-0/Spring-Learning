package com.subham.autowire.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotype_config.xml");
        Student student1 = context.getBean("st", Student.class);
        System.out.println(student1);
        System.out.println(student1.hashCode());
        Student student2 = context.getBean("st", Student.class);
        System.out.println(student2.hashCode());
    }
}
