package ru.job4j.generics;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {

    @Test
    public void whenAddThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        String rsl = array.get(0);
        assertThat(rsl, is("first"));
    }
    @Test
    public void whenSetThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.add("third");
        String rsl = array.set(0, "modelForIndexOne");
        assertThat(rsl, is("modelForIndexOne"));

    }
    @Test
    public void whenRemoveThenGet() {
        SimpleArray<String> array = new SimpleArray<>();
        array.add("first");
        array.add("second");
        array.add("third");
        array.remove(0);
        String rsl = array.get(0);
        assertThat(rsl, is("second"));

    }
}
