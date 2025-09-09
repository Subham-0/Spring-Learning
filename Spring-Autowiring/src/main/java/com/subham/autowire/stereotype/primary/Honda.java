package com.subham.autowire.stereotype.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Honda implements Car {
    @Override
    public void drive() {
        System.out.println("Driving Honda.....");
    }
}
