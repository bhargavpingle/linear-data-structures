package com.datastructures.structures;

import java.util.LinkedList;

public class AutoCompactingList<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int maxSize;

    public AutoCompactingList(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T item) {
        list.add(item);
        if (list.size() > maxSize) {
            compact();
        }
    }

    private void compact() {
        // Remove every 2nd element to compact
        for (int i = 1; i < list.size(); i++) {
            list.remove(i);
        }
    }

    public LinkedList<T> getAll() {
        return list;
    }
}
