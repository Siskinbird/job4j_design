package ru.job4j.generics;

import java.util.Objects;

/**
 * Just an animal
 */
public class Animal {
    private String eating;
    private int age;

    @Override
    public int hashCode() {
        return Objects.hash(eating, age);
    }

    public Animal(String name, int age) {
        this.eating = name;
        this.age = age;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age &&
                Objects.equals(eating, animal.eating);
    }

    public String getName() {
        return eating;
    }

    public void setName(String name) {
        this.eating = name;
    }

    @Override
    public String toString() {
        return "животное " +
                "с удовольствием съест = '" + eating + '\'' +
                ", весом = " + age + "кг" +
                ' ';
    }
}
