package com.subham;

public class App 
{
    public static void main( String[] args )
    {

        System.out.println("Program start...");
        Bike bike1 = new Hero();
        bike1.mileage();
        bike1.engineType();
        Bike bike2 = new Honda();
        bike2.mileage();
        bike2.engineType();
        System.out.println("Program end...");
    }
}
