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
}