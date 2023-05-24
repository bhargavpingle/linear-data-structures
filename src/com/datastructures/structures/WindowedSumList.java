package com.datastructures.structures;

import java.util.LinkedList;

public class WindowedSumList {
    private final int windowSize;
    private final LinkedList<Integer> window = new LinkedList<>();
    private int sum = 0;

    public WindowedSumList(int windowSize) {
        this.windowSize = windowSize;
    }

    public void add(int value) {
        window.add(value);
        sum += value;
        if (window.size() > windowSize) {
            sum -= window.removeFirst();
        }
    }

    public int getSum() {
        return sum;
    }

    public double getAverage() {
        return window.isEmpty() ? 0 : (double) sum / window.size();
    }
}
