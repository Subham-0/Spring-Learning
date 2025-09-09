package com.subham.autowire.stereotype.primary;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("person1")
public class Person {
    private final Car car;

    //    public Person(@Qualifier("honda") Car car) {
//        this.car = car;
//    }
    public Person(@Qualifier("toyota") Car car) {
        this.car = car;
    }

    public void startJourney() {
        car.drive();
    }
}
