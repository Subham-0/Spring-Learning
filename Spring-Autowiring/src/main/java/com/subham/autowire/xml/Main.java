package com.subham.autowire.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml_config.xml");
        Student s1 = context.getBean("st1", Student.class);
        System.out.println(s1);
    }
}
