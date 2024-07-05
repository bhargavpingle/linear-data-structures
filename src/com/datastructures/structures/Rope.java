package com.datastructures.structures;

public class Rope {
    private class Node {
        String data;
        Node next;
        Node(String data) { this.data = data; }
    }

    private Node head;

    public void append(String str) {
        Node newNode = new Node(str);
        if (head == null) head = newNode;
        else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        Node curr = head;
        while (curr != null) {
            sb.append(curr.data);
            curr = curr.next;
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(build());
    }
}
