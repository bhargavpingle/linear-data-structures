package com.datastructures.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NullSkippingList<T> implements Iterable<T> {
    private final List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public List<T> getNonNulls() {
        List<T> nonNulls = new ArrayList<>();
        for (T item : list) {
            if (item != null) nonNulls.add(item);
        }
        return nonNulls;
    }

    @Override
    public Iterator<T> iterator() {
        return getNonNulls().iterator();
    }
}
