package com.datastructures.structures;

import java.util.Random;

public class ReservoirSampler<T> {
    private T sample = null;
    private int count = 0;
    private final Random rand = new Random();

    public void process(T item) {
        count++;
        if (rand.nextInt(count) == 0) {
            sample = item;
        }
    }

    public T getSample() {
        return sample;
    }
}
