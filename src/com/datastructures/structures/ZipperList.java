package com.datastructures.structures;

import java.util.Stack;

public class ZipperList<T> {
    private Stack<T> left = new Stack<>();
    private Stack<T> right = new Stack<>();

    public void moveLeft() {
        if (!left.isEmpty()) right.push(left.pop());
    }

    public void moveRight() {
        if (!right.isEmpty()) left.push(right.pop());
    }

    public void insert(T value) {
        left.push(value);
    }

    public void delete() {
        if (!right.isEmpty()) right.pop();
    }

    public void print() {
        Stack<T> temp = new Stack<>();
        for (T item : left) temp.push(item);
        while (!temp.isEmpty()) System.out.print(temp.pop() + " ");
        System.out.print("| "); // cursor position
        for (int i = right.size() - 1; i >= 0; i--) System.out.print(right.get(i) + " ");
        System.out.println();
    }
}
