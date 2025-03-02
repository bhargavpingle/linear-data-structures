package com.datastructures.structures;

import java.util.LinkedList;

public class MoveToFrontList<T> {
    private final LinkedList<T> list = new LinkedList<>();

    public void access(T item) {
        list.remove(item);
        list.addFirst(item);
    }

    public void add(T item) {
        if (!list.contains(item)) list.addLast(item);
    }

    public LinkedList<T> getList() {
        return list;
    }
}
