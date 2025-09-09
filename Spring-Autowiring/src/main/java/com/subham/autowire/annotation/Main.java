package com.subham.autowire.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext abstractContext =  new ClassPathXmlApplicationContext("annotation_config.xml");
        Student s1 = abstractContext.getBean("st1", Student.class);
        System.out.println(s1);
    }
}
