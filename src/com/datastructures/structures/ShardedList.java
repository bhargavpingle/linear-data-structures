package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class ShardedList<T> {
    private final List<List<T>> shards = new ArrayList<>();
    private final int shardSize;

    public ShardedList(int shardSize) {
        this.shardSize = shardSize;
        shards.add(new ArrayList<>());
    }

    public void add(T item) {
        List<T> last = shards.get(shards.size() - 1);
        if (last.size() >= shardSize) {
            last = new ArrayList<>();
            shards.add(last);
        }
        last.add(item);
    }

    public T get(int index) {
        int shardIndex = index / shardSize;
        int localIndex = index % shardSize;
        return shards.get(shardIndex).get(localIndex);
    }

    public int size() {
        return shards.stream().mapToInt(List::size).sum();
    }
}
