package com.datastructures.structures;

import java.util.List;

public class CircularIterator<T> {
    private final List<T> list;
    private int index = 0;

    public CircularIterator(List<T> list) {
        this.list = list;
    }

    public T next() {
        T item = list.get(index);
        index = (index + 1) % list.size();
        return item;
    }

    public T current() {
        return list.get(index);
    }
}
