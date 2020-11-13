package ru.job4j.generics;

public abstract class Base <T> {
    private final String id;
    private T model;

    protected Base(final String id) {
        this.id = id;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getId() {
        return id;
    }
}