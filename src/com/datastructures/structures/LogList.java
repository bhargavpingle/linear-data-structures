package com.datastructures.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LogList<T> {
    private final List<List<T>> versions = new ArrayList<>();

    public LogList() {
        versions.add(new ArrayList<>());
    }

    public void append(T value) {
        List<T> newVersion = new ArrayList<>(current());
        newVersion.add(value);
        versions.add(newVersion);
    }

    public List<T> current() {
        return versions.get(versions.size() - 1);
    }

    public List<T> getVersion(int index) {
        return versions.get(index);
    }

    public int versionCount() {
        return versions.size();
    }
}
