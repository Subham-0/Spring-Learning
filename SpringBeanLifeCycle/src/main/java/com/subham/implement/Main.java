package com.subham.implement;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext abstractContext =  new ClassPathXmlApplicationContext("interface_config.xml");
        Student student1 = abstractContext.getBean("st", Student.class);
        System.out.println(student1);
        abstractContext.registerShutdownHook();

    }
}
