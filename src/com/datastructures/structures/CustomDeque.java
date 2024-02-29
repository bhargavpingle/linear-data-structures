package com.datastructures.structures;

import java.util.NoSuchElementException;

public class CustomDeque<T> {
    private Object[] data;
    private int front, rear, size;

    public CustomDeque(int capacity) {
        data = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void addFront(T value) {
        if (size == data.length) throw new IllegalStateException("Deque is full");
        front = (front - 1 + data.length) % data.length;
        data[front] = value;
        size++;
    }

    public void addRear(T value) {
        if (size == data.length) throw new IllegalStateException("Deque is full");
        rear = (rear + 1) % data.length;
        data[rear] = value;
        size++;
    }

    public T removeFront() {
        if (size == 0) throw new NoSuchElementException("Deque is empty");
        T value = (T) data[front];
        front = (front + 1) % data.length;
        size--;
        return value;
    }

    public T removeRear() {
        if (size == 0) throw new NoSuchElementException("Deque is empty");
        T value = (T) data[rear];
        rear = (rear - 1 + data.length) % data.length;
        size--;
        return value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i = 0, idx = front; i < size; i++) {
            System.out.print(data[idx] + " ");
            idx = (idx + 1) % data.length;
        }
        System.out.println();
    }
}
