package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        ListUtils.addAfter(input, 2, 4);
        assertThat(Arrays.asList(1, 2, 3, 4, 5), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5));
        ListUtils.addAfter(input, 5, 6);
    }
    @Test
    public void removeIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 8, 111, 749, 14, 42, 7));
        List<Integer> output = ListUtils.removeIf(input, i -> i >= 7);
        assertThat(Arrays.asList(8, 111, 749, 14, 42, 7), Is.is(output));
    }
    @Test
    public void replaceIf() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> output = ListUtils.replaceIf(input, i -> i > 1 , 1);
        assertThat(Arrays.asList(1, 1, 1), Is.is(output));
    }
    @Test
    public void replaceIfBigListFibonaccisEdition() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377));
        List<Integer> output = ListUtils.replaceIf(input, i -> i >= 55 , 42);
        assertThat(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 42, 42, 42, 42, 42), Is.is(output));
    }
    @Test
    public void removeAll() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> elements = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> modified = ListUtils.removeAll(list, elements);
        assertThat(Arrays.asList(3, 4), Is.is(modified));
    }
    @Test
    public void removeAllFibonaccisEdition() {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377));
        List<Integer> elements = new ArrayList<>(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144));
        List<Integer> modified = ListUtils.removeAll(list, elements);
        assertThat(Arrays.asList(233, 377), Is.is(modified));
    }
}