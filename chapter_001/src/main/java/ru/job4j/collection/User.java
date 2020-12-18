package ru.job4j.collection;

import java.util.Calendar;

public class User {

    private String name;
    private int age;
    private Calendar birthday;

    public void newUser(String name, int age, Calendar birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
