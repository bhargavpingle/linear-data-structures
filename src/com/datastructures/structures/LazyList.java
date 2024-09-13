package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LazyList {
    private final int size;
    private final Function<Integer, Integer> generator;
    private final List<Integer> cache;

    public LazyList(int size, Function<Integer, Integer> generator) {
        this.size = size;
        this.generator = generator;
        this.cache = new ArrayList<>(size);
        for (int i = 0; i < size; i++) cache.add(null);
    }

    public int get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (cache.get(index) == null) {
            cache.set(index, generator.apply(index));
        }
        return cache.get(index);
    }

    public int size() {
        return size;
    }
}
