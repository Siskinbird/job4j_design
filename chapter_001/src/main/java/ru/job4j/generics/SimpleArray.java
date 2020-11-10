package ru.job4j.generics;

import java.util.*;

/**
 * Universal wrapper over an array
 * @author Dmitry Chizhov
 * @version 1.10
 * @since 05.11.20
 * @param <T>
 */
public class SimpleArray<T> implements Iterable<T> {
    private int index;
    private int capacity = 10;
    private T[] array = (T[]) new Object[capacity];


    /**
     * The method implements the ability to obtain data by index
     * @param index - Cell number
     * @return - data
     */
    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return array[index];
    }

    /**
     * The method implements the ability to add data
     * @param model - Recorded data
     */

    public void add(T model) {
        array[index] = model;
        index++;
    }

    /**
     * The method implements the ability to set data to a specific cell
     * @param index - Cell number
     * @param model - Recorded data
     * @return - Changed data
     * @throws IndexOutOfBoundsException - The desired index is not in the array
     */

    public T set(int index, T model) throws IndexOutOfBoundsException {
        Objects.checkIndex(index, this.index);
        return array[index] = model;
    }

    /**
     * The method implements the ability to delete data from a specific cell
     * @param index - Cell number
     * @throws IndexOutOfBoundsException - The desired index is not in the array
     */


    public void remove(int index) throws IndexOutOfBoundsException {
       Objects.checkIndex(index, this.index);
        System.arraycopy(array, index + 1, array, index, capacity - this.index-- );
        array[array.length - 1] = null;
    }

    /**
     * An iterator for working with an array
     * @return - iterator<T>
     * @throws - NoSuchElementException
     */

public Iterator<T> iterator(){
    return iterator;
}
    Iterator<T> iterator = new Iterator<T>() {
        int position = 0;

        @Override
        public boolean hasNext() {
            return position < index;
        }

        @Override
        public T next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return array[position++];
        }
    };
}
