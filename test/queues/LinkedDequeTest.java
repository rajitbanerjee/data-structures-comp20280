package queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCode20280.Deque;
import queues.LinkedDeque;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LinkedDeque.
 *
 * @author Rajit Banerjee, 18202817
 */
class LinkedDequeTest {
    private Deque<String> deque;

    @BeforeEach
    void setUp() {
        deque = new LinkedDeque<>();
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
    }

    @Test
    void testAddLast() {
        deque.addLast("A");
        assertEquals("[A]", deque.toString());
        deque.addLast("B");
        assertEquals("[A, B]", deque.toString());
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
