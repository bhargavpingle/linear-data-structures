package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class TransactionalList<T> {
    private final List<T> committed = new ArrayList<>();
    private List<T> uncommitted = null;

    public void begin() {
        uncommitted = new ArrayList<>(committed);
    }

    public void add(T value) {
        if (uncommitted == null) throw new IllegalStateException("Transaction not started");
        uncommitted.add(value);
    }

    public void commit() {
        if (uncommitted != null) {
            committed.clear();
            committed.addAll(uncommitted);
            uncommitted = null;
        }
    }

    public void rollback() {
        uncommitted = null;
    }

    public List<T> getState() {
        return new ArrayList<>(uncommitted != null ? uncommitted : committed);
    }
}
