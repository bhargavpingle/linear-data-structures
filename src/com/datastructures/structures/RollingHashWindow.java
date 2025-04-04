package com.datastructures.structures;

public class RollingHashWindow {
    private final int base;
    private final int mod;
    private final int windowSize;
    private final char[] window;
    private int hash = 0;
    private int power = 1;
    private int index = 0;

    public RollingHashWindow(int size, int base, int mod) {
        this.windowSize = size;
        this.base = base;
        this.mod = mod;
        this.window = new char[size];
        for (int i = 0; i < size - 1; i++)
            power = (power * base) % mod;
    }

    public int roll(char newChar) {
        char oldChar = window[index];
        window[index] = newChar;

        hash = (hash + mod - (oldChar * power) % mod) % mod;
        hash = (hash * base + newChar) % mod;

        index = (index + 1) % windowSize;
        return hash;
    }

    public int getHash() {
        return hash;
    }
}

