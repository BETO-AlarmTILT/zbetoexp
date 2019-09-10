package com.beto.mockito;

public class Student {
    private final String roleNumber;
    private final String name;
    public Student(String roleNumber, String name) {
        this.roleNumber = roleNumber;
        this.name = name;
    }

    //setters are ignored
    public String getRoleNumber() {
        return roleNumber;
    }

    public String getName() {
        return name;
    }

}