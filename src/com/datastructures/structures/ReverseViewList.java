package com.datastructures.structures;

import java.util.List;

public class ReverseViewList<T> {
    private final List<T> base;

    public ReverseViewList(List<T> base) {
        this.base = base;
    }

    public T get(int index) {
        return base.get(base.size() - 1 - index);
    }

    public int size() {
        return base.size();
    }
}
