package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private int index = 0;
    private int capacity = 10;
    private T[] array = (T[]) new Object[capacity];

    public T get(int index) {
        return array[index];
    }

    public void add(T model) {
        array[index] = model;
        index++;
    }
    public T set(int index, T model) throws IndexOutOfBoundsException{
        if (Objects.checkIndex(index, capacity) < 0 || Objects.checkIndex(index, capacity) > capacity){
            throw new IndexOutOfBoundsException();
        }
        return array[index] = model;
    }


    public <T> void remove(int index) throws IndexOutOfBoundsException{
        if (Objects.checkIndex(index, capacity) < 0 || Objects.checkIndex(index, capacity) > capacity){
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array,index+1,array,index,6);
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
