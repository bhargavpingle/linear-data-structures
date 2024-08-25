package com.datastructures.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelfShufflingList<T> {
    private final List<T> data = new ArrayList<>();
    private final int shuffleInterval;
    private int accessCount = 0;

    public SelfShufflingList(int shuffleInterval) {
        this.shuffleInterval = shuffleInterval;
    }

    public void add(T item) {
        data.add(item);
    }

    public T get(int index) {
        accessCount++;
        if (accessCount >= shuffleInterval) {
            Collections.shuffle(data);
            accessCount = 0;
        }
        return data.get(index);
    }

    public List<T> getAll() {
        return data;
    }
}

