package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class ChunkedList<T> {
    private final int chunkSize;
    private final List<List<T>> chunks = new ArrayList<>();

    public ChunkedList(int chunkSize) {
        this.chunkSize = chunkSize;
    }

    public void add(T value) {
        if (chunks.isEmpty() || chunks.get(chunks.size() - 1).size() == chunkSize) {
            chunks.add(new ArrayList<>());
        }
        chunks.get(chunks.size() - 1).add(value);
    }

    public T get(int index) {
        int outer = index / chunkSize;
        int inner = index % chunkSize;
        return chunks.get(outer).get(inner);
    }

    public int size() {
        return (chunks.size() - 1) * chunkSize + chunks.get(chunks.size() - 1).size();
    }
}
