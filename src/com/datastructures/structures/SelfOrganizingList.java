package com.datastructures.structures;

public class SelfOrganizingList<T> {
    private class Node {
        T data;
        Node next;
        Node(T data) { this.data = data; }
    }

    private Node head;

    public void add(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) current = current.next;
        current.next = new Node(data);
    }

    public boolean access(T target) {
        if (head == null) return false;

        if (head.data.equals(target)) return true;

        Node prev = head;
        Node current = head.next;

        while (current != null) {
            if (current.data.equals(target)) {
                // Move to front
                prev.next = current.next;
                current.next = head;
                head = current;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }

    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
