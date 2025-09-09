package com.subham.autowire.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Student {
    private int id;
    private String name;

//    @Autowired
//    @Qualifier("officeAddress")
    private Address address;


    @Autowired
    public Student(@Qualifier("officeAddress") Address homeAddress) {
        System.out.println("autowiring by constructor injection");
        this.address = homeAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    //    @Autowired
//    @Qualifier("homeAddress")
    public void setAddress(Address address) {
        System.out.println("by setter injection");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
