package com.datastructures.structures;

import java.util.Arrays;

public class ArrayListCustom<T> {
    private Object[] array;
    private int size;

    public ArrayListCustom() {
        array = new Object[10];
        size = 0;
    }

    public void add(T value) {
        ensureCapacity();
        array[size++] = value;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = (T) array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[--size] = null;
        return removed;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
    }
}
