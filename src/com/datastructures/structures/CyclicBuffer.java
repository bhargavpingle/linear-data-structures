package com.datastructures.structures;

public class CyclicBuffer<T> {
    private final T[] buffer;
    private int head = 0, tail = 0, size = 0;

    @SuppressWarnings("unchecked")
    public CyclicBuffer(int capacity) {
        buffer = (T[]) new Object[capacity];
    }

    public void add(T value) {
        buffer[tail] = value;
        tail = (tail + 1) % buffer.length;
        if (size < buffer.length) size++;
        else head = (head + 1) % buffer.length;
    }

    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return buffer[(head + index) % buffer.length];
    }

    public int size() {
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
