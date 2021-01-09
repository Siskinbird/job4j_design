package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HazardTable <K, V> implements Iterable<K> {
    private int size = 0;
    private final int capacity = 16;
    private HashNode<K, V>[] table = new HashNode[capacity];

    /**
     * Method insert() adding a key-value pair to a table
     * @param key   - Key
     * @param value - Value
     * @return - Operation Result
     */

    boolean insert(K key, V value) {
        boolean rst = true;
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                rst = false;
                break;
            }

        }
        if (rst) {
            grow();
            table[size++] = new HashNode<>(key, value);
        }
        return rst;
    }

    /**
     * Method grow() - grows the table as it fills
     */

    private void grow() {
        if (size == table.length) {
            int newSize = table.length * 2;
            table = Arrays.copyOf(table, newSize);
        }
    }

    /**
     * Method get() - Implements getting a value by key
     * @param key - Key
     * @return - Value
     */

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                if (table[i].getKey().equals(key)) {
                    return table[i].getValue();
                }
            }
        }
        return null;
    }

    /**
     * Method delete() - Deletes data by key
     * @param key - Key
     * @return - Removal result
     */

    public boolean delete(K key) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                if (table[i].getKey().equals(key)) {
                    table[i] = null;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return size < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[size++].getKey();
            }
        };
    }
}


