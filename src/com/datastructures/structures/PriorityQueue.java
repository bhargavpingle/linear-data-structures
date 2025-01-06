package com.datastructures.structures;

public class PriorityQueue {
    private static class Node {
        int data, priority;
        Node next;

        Node(int data, int priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    private Node head;

    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);
        if (head == null || priority < head.priority) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.priority <= priority)
                current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public int dequeue() {
        if (head == null)
            throw new IllegalStateException("Queue is empty");
        int val = head.data;
        head = head.next;
        return val;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
