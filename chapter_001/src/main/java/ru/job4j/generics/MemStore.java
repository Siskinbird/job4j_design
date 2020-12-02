package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

        private int indexOf(String id) {
            return IntStream.range(0, mem.size())
                    .filter(index -> mem.get(index).getId().equals(id))
                    .findFirst().orElse(-1);
        }

        @Override
        public void add(T model) {
            mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
            int i = indexOf(id);
            if (i != -1) {
            mem.set(i, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
            int i = indexOf(id);
            if (i != -1) {
            mem.remove(i);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        return  mem.stream()
                .filter(i -> i.equals(id))
                .findFirst().orElse(null);
    }
}