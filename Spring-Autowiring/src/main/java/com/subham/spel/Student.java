package com.subham.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Value("#{2+3}")
    public int sum;

    @Value("#{2-3}")
    public int sub;

    @Value("#{2*3}")
    public int mul;

    @Value("#{2/3}")
    public int div;

    @Value("#{1==1}")
    public boolean qual;

    @Value("#{2>3?'Yes':'No'}")
    public String ternaryCheck;

    @Value("#{T(java.lang.Math).sqrt(45)} ")
    public float squareRoot;

    @Value("#{T(java.lang.Math).PI} ")
    public float pi;

    public static String customCall() {
        return "Custom method called";
    }

    @Value("#{T(com.subham.spel.Student).customCall()}")
    public String methodRes;

    @Override
    public String toString() {
        return "Student{" +
                "sum=" + sum +
                ", sub=" + sub +
                ", mul=" + mul +
                ", div=" + div +
                ", qual=" + qual +
                '}';
    }
}
