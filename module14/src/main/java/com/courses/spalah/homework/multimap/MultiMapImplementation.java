package com.courses.spalah.homework.multimap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MultiMapImplementation<K, V> implements MultiMap<K,V> {
    private Collection<V> listValue;
    private HashMap<K, Collection<V>> multiMap= new HashMap<>();

    @Override
    public boolean put(K key, V value) {
        if (multiMap.containsKey(key)) {
            listValue = multiMap.get(key);
            listValue.add(value);
        } else {
            listValue = new ArrayList<>();
            listValue.add(value);

            multiMap.put(key, listValue);
        }
        return true;
    }

    @Override
    public Collection<V> get(K key) {
        if (multiMap.containsKey(key)) {
            return multiMap.get(key);
        } else {
            listValue.clear();
            return listValue;
        }
    }

    @Override
    public Collection<V> removeAll(K key) {
        if (multiMap.containsKey(key)) {
            return multiMap.remove(key);
        }

        listValue.clear();
        return listValue;
    }

    @Override
    public boolean remove(K key, V value) {
        if (multiMap.containsKey(key)) {
            listValue = multiMap.get(key);

            if (listValue.contains(value)) {
                listValue.remove(value);

                if (listValue.size() == 0) {
                    multiMap.remove(key);
                } else {
                    multiMap.put(key, listValue);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Collection<V> allValues() {
        ArrayList<V> allValues = new ArrayList<>();

        for (Collection<V> valuesKey : multiMap.values()) {
            allValues.addAll(valuesKey);
        }
        return allValues;
    }

    @Override
    public boolean containsValue(V value) {
        for (Collection<V> valuesKey : multiMap.values()) {
            if (valuesKey.contains(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return multiMap.isEmpty();
    }

    @Override
    public int size() {
        return allValues().size();
    }
}
