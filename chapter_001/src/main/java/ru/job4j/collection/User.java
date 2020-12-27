package ru.job4j.collection;

import java.util.Calendar;

public class User {

    private String name;
    private int age;
    private Calendar birthday;

    public User(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User [User name =" + name
                + ", User age =" + age
                + ", User birthday" + birthday
                + "]";
    }

}
