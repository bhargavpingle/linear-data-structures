package com.datastructures.structures;

import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindow<T> {
    private final int windowSize;
    private final Queue<T> window = new LinkedList<>();

    public SlidingWindow(int windowSize) {
        this.windowSize = windowSize;
    }

    public void add(T item) {
        if (window.size() == windowSize) {
            window.poll();
        }
        window.offer(item);
    }

    public Queue<T> getWindow() {
        return new LinkedList<>(window);
    }
}
