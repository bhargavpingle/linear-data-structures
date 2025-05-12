package com.datastructures.structures;

import java.time.Instant;
import java.util.LinkedList;

public class TimeStampedList<T> {
    private static class Entry<T> {
        final T data;
        final Instant timestamp;

        Entry(T data) {
            this.data = data;
            this.timestamp = Instant.now();
        }

        public String toString() {
            return "[" + timestamp + "] " + data;
        }
    }

    private final LinkedList<Entry<T>> entries = new LinkedList<>();

    public void add(T item) {
        entries.add(new Entry<>(item));
    }

    public LinkedList<Entry<T>> getAll() {
        return entries;
    }
}
