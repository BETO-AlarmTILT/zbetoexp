package com.beto.exp;

import java.util.Date;

public class MyFirstClass extends AbstractPerson {
    private String name;
    private int age;
    private Date birthday;

    public MyFirstClass(String name, int age, Date birthday) {
        this.name = name;
        this.age = age*2;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "MyFirstClass{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

}
