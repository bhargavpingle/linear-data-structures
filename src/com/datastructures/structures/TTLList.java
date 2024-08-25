package com.datastructures.structures;

import java.time.Instant;
import java.util.Iterator;
import java.util.LinkedList;

public class TTLList<T> {
    private static class Entry<T> {
        T value;
        Instant expiresAt;

        Entry(T value, long ttlMillis) {
            this.value = value;
            this.expiresAt = Instant.now().plusMillis(ttlMillis);
        }
    }

    private final LinkedList<Entry<T>> list = new LinkedList<>();

    public void add(T value, long ttlMillis) {
        list.add(new Entry<>(value, ttlMillis));
    }

    public void purgeExpired() {
        Instant now = Instant.now();
        list.removeIf(entry -> entry.expiresAt.isBefore(now));
    }

    public LinkedList<T> getValidItems() {
        purgeExpired();
        LinkedList<T> result = new LinkedList<>();
        for (Entry<T> entry : list) {
            result.add(entry.value);
        }
        return result;
    }
}
