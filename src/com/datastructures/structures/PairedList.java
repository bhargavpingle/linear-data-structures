package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class PairedList<A, B> {
    private static class Pair<A, B> {
        A first;
        B second;

        Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    private final List<Pair<A, B>> pairs = new ArrayList<>();

    public void add(A a, B b) {
        pairs.add(new Pair<>(a, b));
    }

    public List<A> getFirsts() {
        List<A> list = new ArrayList<>();
        for (Pair<A, B> pair : pairs) list.add(pair.first);
        return list;
    }

    public List<B> getSeconds() {
        List<B> list = new ArrayList<>();
        for (Pair<A, B> pair : pairs) list.add(pair.second);
        return list;
    }

    public int size() {
        return pairs.size();
    }
}
