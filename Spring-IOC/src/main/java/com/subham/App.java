package com.subham;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main( String[] args )
    {
        ApplicationContext context  = new ClassPathXmlApplicationContext("config.xml");
        Hero hero = context.getBean(Hero.class);
        hero.mileage();
        hero.engineType();
        Honda honda = context.getBean(Honda.class);
        honda.mileage();
        honda.engineType();

//        System.out.println("Program start...");
//        Bike bike1 = new Hero();
//        bike1.mileage();
//        bike1.engineType();
//        Bike bike2 = new Honda();
//        bike2.mileage();
//        bike2.engineType();
//        System.out.println("Program end...");
    }
}
