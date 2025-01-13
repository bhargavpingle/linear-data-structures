package com.datastructures.structures;

import java.util.Stack;

public class AmortizedQueue<T> {
    private Stack<T> stackNewest = new Stack<>();
    private Stack<T> stackOldest = new Stack<>();

    public void enqueue(T value) {
        stackNewest.push(value);
    }

    public T dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public boolean isEmpty() {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }

    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
