package com.subham.reference;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("reference_config.xml");
        University university1 = context.getBean("un1", University.class);
        System.out.println(university1);
        University university2 = context.getBean("un2", University.class);
        System.out.println(university2);
    }
}
