package com.datastructures.structures;

public class FlattenedMatrixView {
    private final int[] data;
    private final int rows, cols;

    public FlattenedMatrixView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new int[rows * cols];
    }

    public void set(int row, int col, int val) {
        data[row * cols + col] = val;
    }

    public int get(int row, int col) {
        return data[row * cols + col];
    }

    public int[] rawData() {
        return data;
    }
}
