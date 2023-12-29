package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class StaggeredList<T> {
    private final List<T> fastTier = new ArrayList<>();
    private final List<T> slowTier = new ArrayList<>();
    private final int threshold;

    public StaggeredList(int threshold) {
        this.threshold = threshold;
    }

    public void add(T item) {
        if (fastTier.size() >= threshold) {
            slowTier.addAll(fastTier);
            fastTier.clear();
        }
        fastTier.add(item);
    }

    public List<T> getAll() {
        List<T> combined = new ArrayList<>(slowTier);
        combined.addAll(fastTier);
        return combined;
    }
}
