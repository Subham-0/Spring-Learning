package com.subham.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Emp emp = context.getBean("getEmp", Emp.class);
        System.out.println(emp);
        Emp emp2 = context.getBean("emp2", Emp.class);
        System.out.println(emp2);
    }
}
