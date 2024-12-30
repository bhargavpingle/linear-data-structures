package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class UndoableList<T> {
    private List<T> list = new ArrayList<>();
    private Stack<Command> undoStack = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    private interface Command {
        void undo();
        void redo();
    }

    public void add(T value) {
        list.add(value);
        undoStack.push(() -> list.remove(list.size() - 1));
        redoStack.clear();
    }

    public void removeLast() {
        if (list.isEmpty()) return;
        T removed = list.remove(list.size() - 1);
        undoStack.push(() -> list.add(removed));
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.redo();
            undoStack.push(cmd);
        }
    }

    public void print() {
        System.out.println(list);
    }
}
