package com.subham.con_injection;

import java.util.Map;

public class Project {
    Map<Integer,String> projects;

    public Project(Map<Integer, String> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projects=" + projects +
                '}';
    }
}
