package com.datastructures.structures;

import java.util.Arrays;

/**
 * A simplified version of ArrayList using generics.
 */
public class CustomArrayList<T> {
    private Object[] data;
    private int size;

    public CustomArrayList() {
        data = new Object[10];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        data[size++] = value;
    }

    public T get(int index) {
        checkBounds(index);
        return (T) data[index];
    }

    public void set(int index, T value) {
        checkBounds(index);
        data[index] = value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
