package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SkippableList<T> {
    private final List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }
}
