package projectCode20280;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    private ArrayStack<String> stack;

    @BeforeEach
    void setUp() {
        stack = new ArrayStack<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, stack.size());
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPush() {
        stack.push("A");
        assertEquals("[A]", stack.toString());
        stack.push("B");
        assertEquals("[B, A]", stack.toString());
    }

    @Test
    void testOverflow() {
        stack = new ArrayStack<>(5);
        stack.push("A");
        stack.push("A");
        stack.push("A");
        stack.push("A");
        stack.push("A");
        try {
            stack.push("A");
            fail("Stack overflow!");
        } catch (Exception ignored) {
            // test passed
        }
    }

    @Test
    void testTop() {
        assertNull(stack.top());
        stack.push("A");
        assertEquals("A", stack.top());
        stack.push("B");
        assertEquals("B", stack.top());
    }

    @Test
    void testPop() {
        try {
            stack.pop();
            fail("Stack is empty!");
        } catch (Exception ignored) {
            // test passed
        }
        stack.push("A");
        stack.pop();
        assertEquals("[]", stack.toString());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        assertEquals("[B, A]", stack.toString());
    }

}
