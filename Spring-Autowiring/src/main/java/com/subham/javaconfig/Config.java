package com.subham.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "com.subham.javaconfig")
public class Config {

    @Bean()
    public Emp getEmp(){
        return new Emp();
    }
}
