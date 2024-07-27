package com.datastructures.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InterleavedList<T> {
    private final List<List<T>> sources;

    public InterleavedList(List<List<T>> sources) {
        this.sources = sources;
    }

    public List<T> interleave() {
        List<T> result = new ArrayList<>();
        List<Iterator<T>> iterators = new ArrayList<>();
        for (List<T> src : sources) {
            iterators.add(src.iterator());
        }

        boolean done;
        do {
            done = true;
            for (Iterator<T> it : iterators) {
                if (it.hasNext()) {
                    result.add(it.next());
                    done = false;
                }
            }
        } while (!done);

        return result;
    }
}
