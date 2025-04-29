package com.datastructures.structures;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class JumpTable<T> {
    private final Map<String, Consumer<T>> handlers = new HashMap<>();

    public void register(String key, Consumer<T> handler) {
        handlers.put(key, handler);
    }

    public void execute(String key, T input) {
        Consumer<T> handler = handlers.get(key);
        if (handler != null) {
            handler.accept(input);
        } else {
            System.out.println("No handler for key: " + key);
        }
    }
}
