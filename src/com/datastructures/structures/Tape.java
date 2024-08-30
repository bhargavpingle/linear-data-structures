package com.datastructures.structures;

import java.util.HashMap;

public class Tape {
    private HashMap<Integer, Character> tape = new HashMap<>();
    private int head = 0;

    public void write(char c) {
        tape.put(head, c);
    }

    public char read() {
        return tape.getOrDefault(head, '_');
    }

    public void moveLeft() {
        head--;
    }

    public void moveRight() {
        head++;
    }

    public int getPosition() {
        return head;
    }

    public void printTape() {
        for (int i = head - 5; i <= head + 5; i++) {
            System.out.print(tape.getOrDefault(i, '_') + " ");
        }
        System.out.println();
    }
}
