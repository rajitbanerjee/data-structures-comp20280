package queues;

import interfaces.Deque;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ArrayDeque.
 *
 * @author Rajit Banerjee, 18202817
 */

class ArrayDequeTest {
    private Deque<String> deque;

    @BeforeEach
    void setUp() {
        deque = new ArrayDeque<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, deque.size());
        assertTrue(deque.isEmpty());
    }

    @Test
    void testAddFirst() {
        deque.addFirst("A");
        assertEquals("[A]", deque.toString());
        deque.addFirst("B");
        assertEquals("[B, A]", deque.toString());
        try {
            Deque<String> testDeque = new ArrayDeque<>(1);
            testDeque.addFirst("A");
            testDeque.addFirst("B");
            fail("Deque capacity cannot be exceeded!");
        } catch (Exception ignored) {
            // test passed
        }
    }

    @Test
    void testAddLast() {
        deque.addLast("A");
        assertEquals("[A]", deque.toString());
        deque.addLast("B");
        assertEquals("[A, B]", deque.toString());
        try {
            Deque<String> testDeque = new ArrayDeque<>(1);
            testDeque.addLast("A");
            testDeque.addLast("B");
            fail("Deque capacity cannot be exceeded!");
        } catch (Exception ignored) {
            // test passed
        }
    }

    @Test
    void testFirst() {
        assertNull(deque.first());
        deque.addFirst("C");
        deque.addFirst("B");
        deque.addFirst("A");
        assertEquals("A", deque.first());
        deque.addFirst("F");
        assertEquals("F", deque.first());
    }

    @Test
    void testLast() {
        assertNull(deque.last());
        deque.addFirst("C");
        deque.addFirst("B");
        deque.addFirst("A");
        assertEquals("C", deque.last());
        deque.addLast("F");
        assertEquals("F", deque.last());
    }

    @Test
    void testRemoveFirst() {
        assertNull(deque.removeFirst());
        deque.addFirst("A");
        deque.addFirst("B");
        deque.removeFirst();
        assertEquals("[A]", deque.toString());
        deque.removeFirst();
        assertEquals(0, deque.size());
        assertEquals("[]", deque.toString());
    }

    @Test
    void testRemoveLast() {
        assertNull(deque.removeLast());
        deque.addFirst("A");
        deque.addFirst("B");
        deque.addFirst("C");
        deque.removeLast();
        assertEquals("[C, B]", deque.toString());
        deque.removeLast();
        assertEquals("[C]", deque.toString());
        deque.removeLast();
        assertEquals("[]", deque.toString());
    }

}