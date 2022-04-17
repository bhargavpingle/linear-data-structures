package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class FlaggedList<T> {
    private static class FlaggedItem<T> {
        T value;
        boolean flag;

        FlaggedItem(T value, boolean flag) {
            this.value = value;
            this.flag = flag;
        }
    }

    private final List<FlaggedItem<T>> items = new ArrayList<>();

    public void add(T value, boolean flag) {
        items.add(new FlaggedItem<>(value, flag));
    }

    public void toggle(int index) {
        items.get(index).flag = !items.get(index).flag;
    }

    public List<T> getFlagged(boolean flagState) {
        List<T> result = new ArrayList<>();
        for (FlaggedItem<T> item : items) {
            if (item.flag == flagState) result.add(item.value);
        }
        return result;
    }
}
