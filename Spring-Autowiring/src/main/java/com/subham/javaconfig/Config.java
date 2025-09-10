package com.subham.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//@ComponentScan(basePackages = "com.subham.javaconfig")
public class Config {

    @Bean()
    public Emp getEmp(){
        return new Emp(address1(),"subham");
    }

    @Bean
    public Address address1(){
        return new Address("first bean");
    }

    @Bean
    @Primary
    public Address address2(){
        return new Address("second bean");
    }
}
