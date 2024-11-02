package com.datastructures.structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenedLinkedList<T> implements Iterable<T> {
    private List<List<T>> data = new ArrayList<>();

    public void addList(List<T> subList) {
        data.add(subList);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            int listIndex = 0, itemIndex = 0;

            public boolean hasNext() {
                while (listIndex < data.size()) {
                    if (itemIndex < data.get(listIndex).size()) return true;
                    listIndex++;
                    itemIndex = 0;
                }
                return false;
            }

            public T next() {
                return data.get(listIndex).get(itemIndex++);
            }
        };
    }
}
