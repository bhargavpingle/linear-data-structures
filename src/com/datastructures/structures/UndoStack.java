package com.datastructures.structures;

import java.util.Stack;

public class UndoStack<T> {
    private final Stack<T> undo = new Stack<>();
    private final Stack<T> redo = new Stack<>();

    public void push(T state) {
        undo.push(state);
        redo.clear();
    }

    public T undo() {
        if (undo.size() <= 1) return undo.peek();
        T state = undo.pop();
        redo.push(state);
        return undo.peek();
    }

    public T redo() {
        if (redo.isEmpty()) return undo.peek();
        T state = redo.pop();
        undo.push(state);
        return state;
    }

    public T current() {
        return undo.peek();
    }
}
