package com.datastructures.structures;

import java.util.Arrays;

public class RotatingArray<T> {
    private final T[] data;
    private int offset = 0;

    @SuppressWarnings("unchecked")
    public RotatingArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public void set(int index, T value) {
        data[(offset + index) % data.length] = value;
    }

    public T get(int index) {
        return data[(offset + index) % data.length];
    }

    public void rotateRight(int times) {
        offset = (offset - times + data.length) % data.length;
    }

    public void rotateLeft(int times) {
        offset = (offset + times) % data.length;
    }

    public String toString() {
        return Arrays.toString(toArray());
    }

    public T[] toArray() {
        T[] result = Arrays.copyOf(data, data.length);
        for (int i = 0; i < data.length; i++) {
            result[i] = get(i);
        }
        return result;
    }
}
