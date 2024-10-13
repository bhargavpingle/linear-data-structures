package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class RunLengthEncodedList {
    private static class Entry {
        int value;
        int count;

        Entry(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    private final List<Entry> encoded = new ArrayList<>();

    public void add(int value) {
        if (!encoded.isEmpty() && encoded.get(encoded.size() - 1).value == value) {
            encoded.get(encoded.size() - 1).count++;
        } else {
            encoded.add(new Entry(value, 1));
        }
    }

    public void print() {
        for (Entry e : encoded) {
            System.out.print("(" + e.value + ", " + e.count + ") ");
        }
        System.out.println();
    }
}
