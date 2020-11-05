package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;

public class SimpleArray<T> implements Iterable<T> {
    private int index = 0;
    private ArrayList<T> data = new ArrayList<>();

    public T get(int index) {
        return data.get(index);
    }

    public void add(T model) {
        data.add(model);
        index++;
    }

    public String set(int index, T model) {
        data.set(index, model);
        return model.toString();
    }
    public <T> void remove(int index) {
        data.remove(index);
        this.index--;
    }
    @Override
    public Iterator<T> iterator() {
        return data.iterator();
    }
}
