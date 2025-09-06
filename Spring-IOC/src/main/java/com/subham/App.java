package com.subham;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Program start...");
        Hero hero = new Hero();
        hero.mileage();
        hero.engineType();
        Honda honda = new Honda();
        honda.mileage();
        honda.engineType();
        System.out.println("Program end...");
    }
}
