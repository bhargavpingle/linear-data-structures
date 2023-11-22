package com.datastructures.structures;

public class SinglyLinkedList<T> {

    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    public void addFront(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public void addBack(T data) {
        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> curr = head;
        while (curr.next != null) curr = curr.next;
        curr.next = node;
    }

    public void reverse() {
        Node<T> prev = null, curr = head;
        while (curr != null) {
            Node<T> next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public T getHeadData() {
        return head != null ? head.data : null;
    }

    // Additional methods like remove, find, print can be added
}
