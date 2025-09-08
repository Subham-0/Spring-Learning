package com.subham.con_injection;

public class Staff {
    private int d;
    private String position;
    private String name;
    private boolean isPresent;

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
