package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

/**
 * A class SimpleSet<T> - implements a collection without duplicates
 * @param <T>
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @since 18.12.2020
 * @version 1.01
 */

public class SimpleSet<T> implements Iterable<T> {
    private final SimpleArray<T> jstArr;
    private int size;

    public SimpleSet() {
        this.jstArr = new SimpleArray<>();
        this.size = 0;
    }

    /**
     * The method isContains() - Checking for originality of an element
     * @param value - Item to check
     * @return - Result of checking
     */
    public boolean isContains(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(jstArr.get(i), value)) {
                return true;
            }
        }
       return false;
    }

    /**
     * The method add() - Adds the original element to the collection
     * @param t - Item to add
     * @return - Returns true if the original item is added, if the item is in the collection returns false
     */

    public boolean add(T t) {
        if (!isContains(t) || size == 0) {
            jstArr.add(t);
            size++;
            return true;
        }
        return false;
    }

    /**
     * Method getSize()
     * @return - actual size of list
     */
    public int getSize() {
        return size;
    }

    /**
     * Collection iterator
     * @return - next item
     */

    @Override
    public Iterator<T> iterator() {
        return jstArr.iterator();
    }
}
