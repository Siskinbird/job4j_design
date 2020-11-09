package ru.job4j.generics;

import org.junit.Test;

import java.util.NoSuchElementException;

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
        array.add("zero");
        array.add("first");
        array.add("second");
        array.add("third");
        array.add("four");
        array.add("fifth");
        array.add("six");
        array.remove(5);
        String rsl = array.get(5);
        assertThat(rsl, is("six"));

    }

    @Test
    public void iteratorHasNextAndNext() {
        SimpleArray array = new SimpleArray();
        array.add("zero");
        array.add("first");
        array.add("second");
        assertThat(array.iterator().hasNext(), is(true));
        assertThat(array.iterator().next(), is("zero"));
        assertThat(array.iterator().hasNext(), is(true));
        assertThat(array.iterator().next(), is("first"));
        assertThat(array.iterator().hasNext(), is(true));
        assertThat(array.iterator().next(), is("second"));
        assertThat(array.iterator().hasNext(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        SimpleArray array = new SimpleArray();
        array.iterator().next();
    }
}
