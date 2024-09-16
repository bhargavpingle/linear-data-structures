package com.datastructures.structures;

public class GapBuffer {
    private char[] buffer;
    private int gapStart, gapEnd;

    public GapBuffer(int capacity) {
        buffer = new char[capacity];
        gapStart = 0;
        gapEnd = capacity;
    }

    public void insert(char c) {
        if (gapStart == gapEnd) resize();
        buffer[gapStart++] = c;
    }

    public void moveCursorLeft() {
        if (gapStart == 0) return;
        buffer[--gapEnd] = buffer[--gapStart];
    }

    public void moveCursorRight() {
        if (gapEnd == buffer.length) return;
        buffer[gapStart++] = buffer[gapEnd++];
    }

    private void resize() {
        char[] newBuffer = new char[buffer.length * 2];
        int newGapEnd = newBuffer.length - (buffer.length - gapEnd);
        System.arraycopy(buffer, 0, newBuffer, 0, gapStart);
        System.arraycopy(buffer, gapEnd, newBuffer, newGapEnd, buffer.length - gapEnd);
        gapEnd = newGapEnd;
        buffer = newBuffer;
    }

    public void printBuffer() {
        for (int i = 0; i < gapStart; i++) System.out.print(buffer[i]);
        for (int i = gapEnd; i < buffer.length; i++) System.out.print(buffer[i]);
        System.out.println();
    }
}
