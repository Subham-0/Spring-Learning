package com.subham.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Teacher {
    private String name;
    private List<String> address;
    private Set<String> phone;
    private Map<String, String> classes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAddress() {
        return address;
    }

    public void setAddress(List<String> address) {
        this.address = address;
    }

    public Set<String> getPhone() {
        return phone;
    }

    public void setPhone(Set<String> phone) {
        this.phone = phone;
    }

    public Map<String, String> getClasses() {
        return classes;
    }

    public void setClasses(Map<String, String> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", phone=" + phone +
                ", classes=" + classes +
                '}';
    }
}
