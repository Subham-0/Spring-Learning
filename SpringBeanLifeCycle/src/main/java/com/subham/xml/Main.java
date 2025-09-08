package com.subham.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("xml_based_config.xml");
        Student student = context.getBean("st", Student.class);
        System.out.println(student);
        //but the destroy method is not added to bean
        //for that we have to use AbstractApplicationContext and registerShutdownHook()
        AbstractApplicationContext abstractContext =  new ClassPathXmlApplicationContext("xml_based_config.xml");
        Student student1 = abstractContext.getBean("st", Student.class);
        System.out.println(student1);
        abstractContext.registerShutdownHook();

    }
}
