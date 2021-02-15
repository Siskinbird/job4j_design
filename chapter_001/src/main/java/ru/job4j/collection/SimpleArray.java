package ru.job4j.collection;

import java.util.*;
/**
 * Dynamic list on an array
 * @author Dmitry Chizhov
 * @version 1.00
 * @since 13.11.20
 * @param <T>
 */
@SuppressWarnings({"unchecked"})
public class SimpleArray<T> implements Iterable<T> {

    private T[] container;
    private int modCount;
    private int size;

    public SimpleArray() {
        this.container = (T[]) new Object[10];
        this.modCount = 0;
        this.size = 0;
    }

    /**
     * The method implements the ability to obtain data by index
     * @param index - Cell number
     * @return - data
     */

    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    /**
     * The method implements the ability to add data
     * @param model - Recorded data
     */

    public void add(T model) {
        modCount++;
        if (size == container.length) {
            grow();
        }
        container[size] = model;
        size++;
    }

    /**
     * The method increases the size of the array when filled
     */
    public void grow() {
        int newSize = container.length * 2;
        container = Arrays.copyOf(container, newSize);
    }

    /**
     * An iterator for working with an array
     * @return - iterator<T>
     */

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            int cursor;
            final int currentModCount = modCount;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() throws NoSuchElementException, ConcurrentModificationException {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[cursor++];
            }
        };
    }
}