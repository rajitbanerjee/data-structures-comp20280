package projectCode20280;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for LinkedQueue.
 *
 * @author Rajit Banerjee, 18202817
 */
class LinkedQueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new LinkedQueue<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueue() {
        queue.enqueue("A");
        assertEquals("[A]", queue.toString());
        queue.enqueue("B");
        assertEquals("[A, B]", queue.toString());
    }

    @Test
    void testFirst() {
        assertNull(queue.first());
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("A");
        assertEquals("C", queue.first());
        queue.enqueue("F");
        assertEquals("C", queue.first());
    }

    @Test
    void testDequeue() {
        assertNull(queue.dequeue());
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("A");
        assertEquals("[C, B, A]", queue.toString());
        queue.dequeue();
        assertEquals("[B, A]", queue.toString());
        queue.dequeue();
        assertEquals("[A]", queue.toString());
    }

}
