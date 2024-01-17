package com.datastructures.structures;

import java.util.Stack;

public class DequeWithTwoStacks<T> {
    private final Stack<T> front = new Stack<>();
    private Stack<T> back = new Stack<>();

    public void addFirst(T value) {
        front.push(value);
    }

    public void addLast(T value) {
        back.push(value);
    }

    public T removeFirst() {
        if (front.isEmpty()) {
            while (!back.isEmpty())
                front.push(back.pop());
        }
        return front.isEmpty() ? null : front.pop();
    }

    public T removeLast() {
        if (back.isEmpty()) {
            while (!front.isEmpty())
                back.push(front.pop());
        }
        return back.isEmpty() ? null : back.pop();
    }

    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }
}
