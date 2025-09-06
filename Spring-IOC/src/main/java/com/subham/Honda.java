package com.subham;

public class Honda implements Bike {
    public Honda() {
        System.out.println("Honda object is created");
    }

    @Override
    public void mileage() {
        System.out.println("Honda Bike mileage : 55kmp - 70kmp");
    }

    @Override
    public void engineType() {
        System.out.println("Honda : 4-Stroke engine");
    }
}
