package ru.job4j.collection;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class VirusHashMap<K, V extends Viruses> implements Iterable<K>{
    Map<K, V> map = new Hashtable<>(16, (float)0.75);

    public boolean insert(K key, V value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
            return true;
        }
        return false;
    }
    //TODO get Value at Key
    public V get(K key) {
        return  map.get(key);

    }

    //TODO delete Key&Value
    public boolean delete(K key) {
        if (map.containsKey(key)){
            map.remove(key);
            return true;
        }
        return false;

    }

    @Override
    public Iterator<K> iterator() {
        return map.keySet().iterator();
    }
}
