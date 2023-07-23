package com.datastructures.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VersionedList<T> {
    private final Map<Integer, List<T>> versions = new HashMap<>();
    private List<T> current = new ArrayList<>();
    private int version = 0;

    public void add(T value) {
        snapshot();
        current.add(value);
    }

    public void remove(int index) {
        snapshot();
        current.remove(index);
    }

    private void snapshot() {
        versions.put(++version, new ArrayList<>(current));
    }

    public List<T> getVersion(int ver) {
        return versions.getOrDefault(ver, new ArrayList<>());
    }

    public List<T> getCurrent() {
        return new ArrayList<>(current);
    }

    public int getCurrentVersion() {
        return version;
    }
}
