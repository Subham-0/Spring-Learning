package com.subham.primitive;

public class Student {
    private int id;
    private String name;
    private String address;

    public Student() {
        System.out.println("student object created");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("Setter injection : "+id);
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter injection : "+name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("Setter injection : "+address);
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
