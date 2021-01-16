package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedContainer<E extends Node<E>> implements Iterable<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;
    private int modCount = 0;

    void addLast(E value) {
        final Node<E> lastNode = last;
        final Node<E> newNode = new Node<>(lastNode, value, null);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        size++;
        modCount++;
    }
}

        public E get(int index) {
            Objects.checkIndex(index, size);
            Node<E> rsl = first;
            for (int i = 0; i < index; i++) {
                rsl = rsl.next;
            }
            return rsl.item;
        }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            private Node<E> current = first;
            private int nextIndex;
            private final int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return nextIndex < size;
            }

            @Override
            public E next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> lastReturned = current;
                current = current.next;
                nextIndex++;
                return lastReturned.getItem();
            }
        };
    }
}