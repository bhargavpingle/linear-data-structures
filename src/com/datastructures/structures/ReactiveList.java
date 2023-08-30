package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReactiveList<T> {
    private final List<T> list = new ArrayList<>();
    private final List<Consumer<T>> listeners = new ArrayList<>();

    public void addListener(Consumer<T> listener) {
        listeners.add(listener);
    }

    public void add(T item) {
        list.add(item);
        for (Consumer<T> listener : listeners) {
            listener.accept(item);
        }
    }

    public T get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }
}
