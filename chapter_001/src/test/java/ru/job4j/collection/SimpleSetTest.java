package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSetTest {

    @Test(expected = NoSuchElementException.class)
    public void ifContains() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(4);
        array.add(4);
        Iterator<Integer> it = array.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(4));
    }

    @Test
    public void sizeCheck() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(4);
        array.add(4);
        assertThat(array.getSize(), is(4));
    }

    @Test
    public void addCheckFalse() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(42);
        assertThat(array.add(42), is(false));
    }

    @Test
    public void addCheckTrue() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(42);
        assertThat(array.add(420), is(true));
    }

    @Test
    public void addCheckSizeOneAndFalse() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        assertThat(array.add(42), is(false));
        assertThat(array.getSize(), is(1));
    }

    @Test
    public void addCheckSizeMoreThanOneAndTrue() {
        SimpleSet<Integer> array = new SimpleSet<>();
        array.add(42);
        array.add(43);
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        array.add(42);
        assertThat(array.add(44), is(true));
        assertThat(array.getSize(), is(3));
    }

}