package com.datastructures.structures;

import java.util.ArrayList;

public class SparseArray {
    private static class Entry {
        int index, value;
        Entry(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    private ArrayList<Entry> entries = new ArrayList<>();

    public void add(int index, int value) {
        for (Entry entry : entries) {
            if (entry.index == index) {
                entry.value = value;
                return;
            }
        }
        entries.add(new Entry(index, value));
    }

    public int get(int index) {
        for (Entry entry : entries) {
            if (entry.index == index) return entry.value;
        }
        return 0; // default for sparse
    }

    public void print() {
        for (Entry e : entries) {
            System.out.println("[" + e.index + "] = " + e.value);
        }
    }
}
