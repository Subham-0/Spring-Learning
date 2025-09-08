package com.subham.con_injection;

import java.util.List;

public class Staff {
    private int d;
    private String position;
    private String name;
    private boolean isPresent;
    private List<String> subjects;
    private Project project;

    public Staff(int d,String position ,String name, boolean isPresent) {
        this.d = d;
        this.position = position;
        this.name = name;
        this.isPresent = isPresent;
    }

    public Staff(String name, String position, boolean isPresent) {

        this.position = position;
        this.name = name;
        this.isPresent = isPresent;
    }

    public Staff(int d, String name, boolean isPresent) {
        this.d = d;
        this.name = name;
        this.isPresent = isPresent;
    }

    public Staff(int d, String position, String name, boolean isPresent, List<String> subjects, Project project) {
        this.d = d;
        this.position = position;
        this.name = name;
        this.isPresent = isPresent;
        this.subjects = subjects;
        this.project = project;
    }

    public String PrintAllDetails() {
        return "Staff{" +
                "d=" + d +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", isPresent=" + isPresent +
                ", subjects=" + subjects +
                ", project=" + project +
                '}';
    }

    @Override
    public String toString() {
        return "Staff{" +
                "d=" + d +
                ", position='" + position + '\'' +
                ", name='" + name + '\'' +
                ", isPresent=" + isPresent +
                '}';
    }
}
