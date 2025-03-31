package com.datastructures.structures;

import java.util.LinkedList;
import java.util.Queue;

public class SelfClearingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int threshold;
    private int operationCount = 0;

    public SelfClearingQueue(int threshold) {
        this.threshold = threshold;
    }

    public void enqueue(T value) {
        if (++operationCount > threshold) {
            queue.clear();
            operationCount = 1;
        }
        queue.offer(value);
    }

    public T dequeue() {
        if (++operationCount > threshold) {
            queue.clear();
            operationCount = 1;
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
