package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FlatMapList<T, R> {
    private final List<T> input;

    public FlatMapList(List<T> input) {
        this.input = input;
    }

    public List<R> flatMap(Function<T, List<R>> mapper) {
        List<R> result = new ArrayList<>();
        for (T t : input) {
            result.addAll(mapper.apply(t));
        }
        return result;
    }
}
