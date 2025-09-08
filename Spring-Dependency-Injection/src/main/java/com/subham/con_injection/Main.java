package com.subham.con_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("constructor_config.xml");
        Staff staff1 = context.getBean("staff1", Staff.class);
        System.out.println(staff1);
        Staff staff2 = context.getBean("staff2", Staff.class);
        System.out.println(staff2);
        Staff staff3 = context.getBean("staff3", Staff.class);
        System.out.println(staff3);
        Staff staff4 = context.getBean("staff4", Staff.class);
        System.out.println(staff4);
        Staff staff5 = context.getBean("staff5", Staff.class);
        System.out.println(staff5);
        Staff staff6 = context.getBean("staff6", Staff.class);
        System.out.println(staff6.PrintAllDetails());
    }
}
