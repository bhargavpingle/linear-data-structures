package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class RateLimitedList<T> {
    private final List<T> list = new ArrayList<>();
    private final long delayMillis;
    private long lastAddedTime = 0;

    public RateLimitedList(long delayMillis) {
        this.delayMillis = delayMillis;
    }

    public boolean add(T item) {
        long now = System.currentTimeMillis();
        if (now - lastAddedTime >= delayMillis) {
            list.add(item);
            lastAddedTime = now;
            return true;
        }
        return false;
    }

    public List<T> getAll() {
        return new ArrayList<>(list);
    }
}
