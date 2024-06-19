package com.datastructures.structures;

import java.util.LinkedList;

public class EvictingList<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int maxSize;

    public EvictingList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        if (list.size() == maxSize) {
            list.removeFirst();
        }
        list.addLast(item);
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public LinkedList<T> getAll() {
        return new LinkedList<>(list);
    }
}
