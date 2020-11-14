package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T>{

    private final List<T> mem = new ArrayList<>();

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (indexOf(id) != -1) {
            mem.set(indexOf(id), model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (indexOf(id) != -1) {
            mem.remove(indexOf(id));
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return (T) mem.stream().filter(i -> i.equals(id)).findFirst().orElse(null);
    }
}