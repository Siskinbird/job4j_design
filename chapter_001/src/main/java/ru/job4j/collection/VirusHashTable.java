package ru.job4j.collection;

import java.util.*;

public class VirusHashTable<K , V extends Hazard> implements Iterable<K>{
    private final Hashtable<K, V> hashtable = new Hashtable<>(3, (float)0.75);

    public boolean insert(K key, V value) {
        if (!hashtable.containsKey(key) && key != null) {
            hashtable.put(key, value);
            return true;
        }
        return false;
    }

    public V get(K key) {
        while (iterator().hasNext()){
            if (hashtable.containsKey(key)){
                return hashtable.get(key);
            }
        }
        return  null;
    }

    public boolean delete(K key) {
        if (hashtable.containsKey(key)){
            hashtable.remove(key);
            return true;
        }
        return false;

    }

    @Override
    public Iterator<K> iterator() {
        return hashtable.keySet().iterator();
    }
}
