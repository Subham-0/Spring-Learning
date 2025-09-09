package com.subham.autowire.stereotype.primary;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("stereotype_config.xml");
        Person person = context.getBean("person1", Person.class);
        person.startJourney();
    }
}
