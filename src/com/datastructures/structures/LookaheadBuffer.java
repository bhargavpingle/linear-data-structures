package com.datastructures.structures;

import java.util.LinkedList;
import java.util.Queue;

public class LookaheadBuffer<T> {
    private final Queue<T> buffer = new LinkedList<>();
    private final int maxSize;

    public LookaheadBuffer(int maxSize) {
        this.maxSize = maxSize;
    }

    public void add(T value) {
        if (buffer.size() == maxSize) buffer.poll();
        buffer.offer(value);
    }

    public T peekAhead(int k) {
        if (k >= buffer.size()) return null;
        return buffer.stream().skip(k).findFirst().orElse(null);
    }

    public int size() {
        return buffer.size();
    }
}
