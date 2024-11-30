package com.datastructures.structures;

import java.util.Stack;

public class FreeList<T> {
    private final Stack<T> pool = new Stack<>();

    public void release(T item) {
        pool.push(item);
    }

    public T acquire() {
        return pool.isEmpty() ? null : pool.pop();
    }

    public int available() {
        return pool.size();
    }
}
