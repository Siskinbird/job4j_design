package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T>{

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (model.getId().equals(id)){
            delete(id);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (mem.stream().equals(id)) {
            return mem.remove(id);
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return (T) mem.stream().filter(i -> i.equals(id)).findFirst().orElse(null);
    }
}