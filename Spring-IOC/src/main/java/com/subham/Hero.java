package com.subham;

public class Hero implements Bike {
    public Hero() {
        System.out.println("Hero object is created");
    }

    @Override
    public void mileage() {
        System.out.println("Hero Bike mileage : 45kmp - 65kmp");
    }

    @Override
    public void engineType() {
        System.out.println("Hero : 2-Stroke engine");
    }

}
