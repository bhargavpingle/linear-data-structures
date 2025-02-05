package com.datastructures.structures;

public class BitList {
    private int[] bits;
    private int size = 0;

    public BitList(int capacity) {
        bits = new int[(capacity + 31) / 32];
    }

    public void add(boolean value) {
        if (size >= bits.length * 32) throw new IndexOutOfBoundsException();
        if (value) bits[size / 32] |= (1 << (size % 32));
        size++;
    }

    public boolean get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return (bits[index / 32] & (1 << (index % 32))) != 0;
    }

    public int size() {
        return size;
    }
}
