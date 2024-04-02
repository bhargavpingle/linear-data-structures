package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class AccumulatorList {
    private final List<Integer> list = new ArrayList<>();
    private int sum = 0;

    public void add(int val) {
        sum += val;
        list.add(sum);
    }

    public int getSumUpTo(int index) {
        if (index < 0 || index >= list.size()) return 0;
        return list.get(index);
    }

    public List<Integer> getAccumulated() {
        return list;
    }
}
