package com.datastructures.tests;

import com.datastructures.structures.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinglyLinkedListTest {

    @Test
    public void testAddAndReverse() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addBack(1);
        list.addBack(2);
        list.addBack(3);

        assertEquals(1, list.getHeadData());

        list.reverse();

        assertEquals(3, list.getHeadData());
    }
}
