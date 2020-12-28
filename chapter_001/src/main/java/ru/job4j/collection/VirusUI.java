package ru.job4j.collection;

public interface VirusUI <K, V extends Hazard> {

    boolean insert(K key, V value);

    V get(K key);

    boolean delete(K key);
}
