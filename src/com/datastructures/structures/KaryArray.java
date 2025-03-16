package com.datastructures.structures;

public class KaryArray {
    private final int[] data;
    private final int k;

    public KaryArray(int capacity, int k) {
        this.data = new int[capacity];
        this.k = k;
    }

    public int getParent(int index) {
        return (index - 1) / k;
    }

    public int getChild(int index, int childIndex) {
        return k * index + childIndex + 1;
    }

    public void set(int index, int value) {
        data[index] = value;
    }

    public int get(int index) {
        return data[index];
    }
}
