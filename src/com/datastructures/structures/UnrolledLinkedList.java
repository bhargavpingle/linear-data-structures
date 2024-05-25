package com.datastructures.structures;

public class UnrolledLinkedList<T> {
    private static final int NODE_CAPACITY = 4;

    private class Node {
        Object[] elements = new Object[NODE_CAPACITY];
        int numElements = 0;
        Node next;
    }

    private Node head = new Node();

    public void add(T data) {
        Node current = head;
        while (current.numElements == NODE_CAPACITY) {
            if (current.next == null) current.next = new Node();
            current = current.next;
        }
        current.elements[current.numElements++] = data;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            for (int i = 0; i < current.numElements; i++) {
                System.out.print(current.elements[i] + " ");
            }
            current = current.next;
        }
        System.out.println();
    }
}
