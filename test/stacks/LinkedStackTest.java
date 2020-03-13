package stacks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stacks.LinkedStack;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LinkedStack.
 *
 * @author Rajit Banerjee, 18202817
 */
class LinkedStackTest {
    private LinkedStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new LinkedStack<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPush() {
        assertNull(stack.top());
        stack.push("A");
        assertEquals("[A]", stack.toString());
        stack.push("B");
        assertEquals("[B, A]", stack.toString());
    }

    @Test
    void testTop() {
        stack.push("A");
        assertEquals("A", stack.top());
        stack.push("B");
        assertEquals("B", stack.top());
    }

    @Test
    void testPop() {
        assertNull(stack.pop());
        stack.push("A");
        stack.pop();
        assertEquals("[]", stack.toString());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        assertEquals("[B, A]", stack.toString());
    }

    @Test
    void testReverse() {
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("[C, B, A]", stack.toString());
        stack.reverse();
        assertEquals("[A, B, C]", stack.toString());
    }

}
