package com.datastructures.structures;

import java.util.LinkedList;

public class SlidingWindowQueue<T> {
    private final LinkedList<T> window = new LinkedList<>();
    private final int capacity;

    public SlidingWindowQueue(int capacity) {
        this.capacity = capacity;
    }

    public void add(T value) {
        if (window.size() == capacity) {
            window.removeFirst();
        }
        window.addLast(value);
    }

    public T oldest() {
        return window.getFirst();
    }

    public T newest() {
        return window.getLast();
    }

    public void print() {
        System.out.println(window);
    }
}

