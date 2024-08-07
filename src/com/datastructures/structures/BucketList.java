package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class BucketList {
    private List<List<Integer>> buckets;

    public BucketList(int numBuckets) {
        buckets = new ArrayList<>();
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public void add(int value) {
        int bucketIndex = value % buckets.size();
        buckets.get(bucketIndex).add(value);
    }

    public void print() {
        for (int i = 0; i < buckets.size(); i++) {
            System.out.println("Bucket " + i + ": " + buckets.get(i));
        }
    }
}

