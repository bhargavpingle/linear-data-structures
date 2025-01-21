package com.datastructures.structures;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] forward;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 4;
    private final SkipListNode head = new SkipListNode(-1, MAX_LEVEL);
    private int level = 0;
    private final Random rand = new Random();

    public void insert(int value) {
        SkipListNode[] update = new SkipListNode[MAX_LEVEL + 1];
        SkipListNode current = head;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value)
                current = current.forward[i];
            update[i] = current;
        }

        int newLevel = randomLevel();
        if (newLevel > level) {
            for (int i = level + 1; i <= newLevel; i++)
                update[i] = head;
            level = newLevel;
        }

        SkipListNode newNode = new SkipListNode(value, newLevel);
        for (int i = 0; i <= newLevel; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean search(int value) {
        SkipListNode current = head;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value)
                current = current.forward[i];
        }
        current = current.forward[0];
        return current != null && current.value == value;
    }

    private int randomLevel() {
        int lvl = 0;
        while (rand.nextBoolean() && lvl < MAX_LEVEL) lvl++;
        return lvl;
    }
}
