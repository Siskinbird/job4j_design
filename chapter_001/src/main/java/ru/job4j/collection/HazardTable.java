package ru.job4j.collection;

import java.util.*;

/**
 * Own implementation of the internal work of the associative array HashTable
 * @author Dmitry Chizhov (dimachig@gmail.com)
 * @version 1.99
 * @since 27.12.20
 * @param <K> - Key
 * @param <V> - Value
 */

@SuppressWarnings({"unchecked"})

public class HazardTable<K, V> implements Iterable<K> {
    private int size = 0;
    private final int defaultCapacity = 16;
    private final double loadFactor = 0.75D;
    private MyNode<K, V>[] table = new MyNode[defaultCapacity];

    private int modCount;

    /**
     * hash function
     */

    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * Method insert() adding a key-value pair to a table
     * @param key   - Key
     * @param value - Value
     * @return - Operation Result
     */

    boolean insert(K key, V value) {
        if (size >= fullness()) {
            table = resize();
        }
        if (size < fullness()) {
            int i = getBucketIndex(key);
            if (table[i] == null) {
                table[i] = new MyNode<>(hash(key.hashCode()), key, value);
                size++;
                modCount++;
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Method resize() - grows the table as it fills
     */

    private MyNode<K, V>[] resize() {
        int index;
        MyNode<K, V>[] newTable = new MyNode[(int) (defaultCapacity * 6)];
        MyNode<K, V>[] oldTable = table;
        for (MyNode<K, V> old : oldTable) {
            index = old.hash % (newTable.length - 1);
            if (newTable[index] == null && old.key != null) {
                newTable[index] = old;
                return newTable;
            }
        }
        return null;
    }

    /**
     * Index for hash
     */

    static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    /**
     * Bucket index
     * @return index of bucket
     */

    private int getBucketIndex(K key) {
        if (key != null) {
            int hash = hash(key.hashCode());
            return indexFor(hash, table.length);
        }
        return 0;
    }

    /**
     * Fullness
     */

    private int fullness() {
        return (int) (table.length * loadFactor);
    }

    /**
     * Method get() - Implements getting a value by key
     * @param key - Key
     * @return - Value
     */

    public V get(K key) {
        if (table[getBucketIndex(key)] != null) {
            if (table[getBucketIndex(key)].getKey().equals(key)) {
                return table[getBucketIndex(key)].getValue();
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

        if (table[getBucketIndex(key)] != null && table[getBucketIndex(key)].getKey().equals(key)) {
                table[getBucketIndex(key)] = null;
                size--;
                modCount++;
                return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            final int currentModCount = modCount;
            int count;
            int cursor;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public K next() throws NoSuchElementException, ConcurrentModificationException {
                if (currentModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[cursor] == null) {
                    cursor++;
                }
                count++;
                return table[cursor++].getKey();
            }
        };
    }

    /**
     * MyNode
     * @param <K>
     * @param <V>
     */

    static class MyNode<K, V> {
        private final int hash;
        private final K key;
        private final V value;

        public MyNode(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;

        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            MyNode<?, ?> myNode = (MyNode<?, ?>) o;
            return hash == myNode.hash && Objects.equals(key, myNode.key) && Objects.equals(value, myNode.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hash, key, value);
        }
    }
}





