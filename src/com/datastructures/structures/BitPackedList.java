package com.datastructures.structures;

import java.util.BitSet;

public class BitPackedList {
    private final BitSet bits = new BitSet();
    private final int bitWidth;
    private int count = 0;

    public BitPackedList(int bitWidth) {
        this.bitWidth = bitWidth;
    }

    public void add(int value) {
        int base = count * bitWidth;
        for (int i = 0; i < bitWidth; i++) {
            if ((value & (1 << i)) != 0) {
                bits.set(base + i);
            }
        }
        count++;
    }

    public int get(int index) {
        int base = index * bitWidth;
        int value = 0;
        for (int i = 0; i < bitWidth; i++) {
            if (bits.get(base + i)) {
                value |= (1 << i);
            }
        }
        return value;
    }

    public int size() {
        return count;
    }
}
