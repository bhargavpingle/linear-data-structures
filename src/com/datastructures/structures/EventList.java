package com.datastructures.structures;

import java.time.Instant;
import java.util.LinkedList;

public class EventList<T> {
    private static class Event<T> {
        T value;
        Instant timestamp;

        Event(T value) {
            this.value = value;
            this.timestamp = Instant.now();
        }
    }

    private final LinkedList<Event<T>> events = new LinkedList<>();

    public void record(T value) {
        events.add(new Event<>(value));
    }

    public LinkedList<T> getRecent(long seconds) {
        LinkedList<T> result = new LinkedList<>();
        Instant cutoff = Instant.now().minusSeconds(seconds);
        for (Event<T> e : events) {
            if (e.timestamp.isAfter(cutoff)) {
                result.add(e.value);
            }
        }
        return result;
    }
}
