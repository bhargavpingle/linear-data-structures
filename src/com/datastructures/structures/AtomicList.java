package com.datastructures.structures;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AtomicList<T> {
    private final CopyOnWriteArrayList<T> list = new CopyOnWriteArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public List<T> snapshot() {
        return List.copyOf(list);
    }
}

