package com.datastructures.structures;

import java.util.HashMap;
import java.util.Map;

public class FrequencyList<T> {
    private final Map<T, Integer> freq = new HashMap<>();

    public void add(T item) {
        freq.put(item, freq.getOrDefault(item, 0) + 1);
    }

    public int getFrequency(T item) {
        return freq.getOrDefault(item, 0);
    }

    public Map<T, Integer> getAll() {
        return freq;
    }
}
