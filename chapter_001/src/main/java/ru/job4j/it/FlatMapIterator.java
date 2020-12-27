package ru.job4j.it;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class FlatMapIterator <K> implements Iterator<K> {
    private Iterator<K> keyIterator = Collections.emptyIterator();


    public FlatMapIterator(Iterator<K> keyIterator) {
        this.keyIterator = keyIterator;
    }

    @Override
    public boolean hasNext() {
        while (keyIterator.hasNext()) {
           keyIterator.next();
        }
        return false;
    }

    @Override
    public K next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return keyIterator.next();
    }
}
