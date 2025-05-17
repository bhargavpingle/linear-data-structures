package com.datastructures.structures;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingMaxQueue {
    private final int windowSize;
    private final Deque<Integer> data = new ArrayDeque<>();
    private final Deque<Integer> maxDeque = new ArrayDeque<>();

    public SlidingMaxQueue(int windowSize) {
        this.windowSize = windowSize;
    }

    public void add(int val) {
        data.addLast(val);
        while (!maxDeque.isEmpty() && maxDeque.getLast() < val)
            maxDeque.removeLast();
        maxDeque.addLast(val);
        if (data.size() > windowSize) {
            int removed = data.removeFirst();
            if (removed == maxDeque.getFirst()) maxDeque.removeFirst();
        }
    }

    public int getMax() {
        return maxDeque.getFirst();
    }
}

