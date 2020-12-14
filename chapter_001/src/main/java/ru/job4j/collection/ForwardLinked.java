package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    /**
     * Adds an item to the list
     */
    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    /**
     * Check for emptiness
     * @return - result
     */

    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Removes the first element of the list
     * @return value
     */

    public T deleteFirst() {
        if (head != null) {
            final T value = head.value;
            final Node<T> newHead = head.next;
            head.next = null;
            head = newHead;
            return value;
        } else {
            throw new NoSuchElementException();
        }
    }

    /**
     * Removes the last element of the list
     * @return value
     */

    public T deleteLast() {
        Node<T> prev = head;
        Node<T> next = head;
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        while (next.next != null) {
            prev = next;
            next = next.next;
        }
        if (next == head) {
            head = null;
        }
        prev.next = null;
        return next.value;
    }

    /**
     *Inverted list
     */

    public void revert() {
        if (!isEmpty() && head.next != null) {
            Node<T> current = head.next;
            head.next = null;
            while (current != null){
                Node<T> next = current.next;
                current.next = head;
                head = current;
                current = next;
            }
        }
    }

    /**
     * Node data model
     * @param <T>
     */

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Iterator
     * @return next element
     */
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}
