package com.datastructures.structures;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private Object[] queue;
    private int front, rear, size;

    public CircularQueue(int capacity) {
        queue = new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T value) {
        if (size == queue.length) throw new IllegalStateException("Queue is full");
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        size++;
    }

    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("Queue is empty");
        T value = (T) queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public T peek() {
        if (size == 0) throw new NoSuchElementException("Queue is empty");
        return (T) queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void print() {
        for (int i = 0, idx = front; i < size; i++) {
            System.out.print(queue[idx] + " ");
            idx = (idx + 1) % queue.length;
        }
        System.out.println();
    }
}
