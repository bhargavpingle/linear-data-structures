package com.datastructures.structures;

import java.util.ArrayList;
import java.util.List;

public class TaggedUnionList {
    public static class Entry {
        public enum Type { INT, STR, BOOL }

        public final Type type;
        public final Object value;

        public Entry(Type type, Object value) {
            this.type = type;
            this.value = value;
        }

        public String toString() {
            return type + ":" + value;
        }
    }

    private final List<Entry> list = new ArrayList<>();

    public void addInt(int i) {
        list.add(new Entry(Entry.Type.INT, i));
    }

    public void addString(String s) {
        list.add(new Entry(Entry.Type.STR, s));
    }

    public void addBool(boolean b) {
        list.add(new Entry(Entry.Type.BOOL, b));
    }

    public List<Entry> getAll() {
        return list;
    }
}

