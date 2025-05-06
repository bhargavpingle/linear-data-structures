package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class RunLengthList<T> {
    private static class Pair<T> {
        T value;
        int count;

        Pair(T value, int count) {
            this.value = value;
            this.count = count;
        }

        public String toString() {
            return "(" + value + " x" + count + ")";
        }
    }

    private final List<Pair<T>> data = new ArrayList<>();

    public void add(T value) {
        if (!data.isEmpty() && data.get(data.size() - 1).value.equals(value)) {
            data.get(data.size() - 1).count++;
        } else {
            data.add(new Pair<>(value, 1));
        }
    }

    public List<Pair<T>> getCompressed() {
        return data;
    }

    public String toString() {
        return data.toString();
    }
}

