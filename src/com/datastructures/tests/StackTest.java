package com.datastructures.tests;

import com.datastructures.structures.Stack;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    @Test
    public void testPushPopPeek() {
        Stack<Integer> stack = new Stack<>();
        assertTrue(stack.isEmpty());

        stack.push(10);
        stack.push(20);
        assertFalse(stack.isEmpty());
        assertEquals(20, stack.peek());

        assertEquals(20, stack.pop());
        assertEquals(10, stack.peek());
        assertEquals(10, stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testPopEmptyStack() {
        Stack<Integer> stack = new Stack<>();
        assertThrows(EmptyStackException.class, stack::pop);
    }
}
