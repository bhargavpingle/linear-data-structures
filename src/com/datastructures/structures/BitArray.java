package com.datastructures.structures;

public class BitArray {
    private byte[] bits;
    private int size;

    public BitArray(int numBits) {
        size = numBits;
        bits = new byte[(numBits + 7) / 8];
    }

    public void set(int index) {
        bits[index / 8] |= (1 << (index % 8));
    }

    public void clear(int index) {
        bits[index / 8] &= ~(1 << (index % 8));
    }

    public boolean get(int index) {
        return (bits[index / 8] & (1 << (index % 8))) != 0;
    }

    public void printBits() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) ? "1" : "0");
        }
        System.out.println();
    }
}
