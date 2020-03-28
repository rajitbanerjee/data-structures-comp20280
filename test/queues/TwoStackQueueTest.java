package queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projectCode20280.Queue;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for TwoStackQueue.
 *
 * @author Rajit Banerjee, 18202817
 */
class TwoStackQueueTest {
    private Queue<String> queue;
    private String out;

    @BeforeEach
    void setUp() {
        queue = new TwoStackQueue<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    void testEnqueue() {
        queue.enqueue("A");
        out = "Enqueue stack: [A]\nDequeue stack: []\n";
        assertEquals(out, queue.toString());
        queue.enqueue("B");
        out = "Enqueue stack: [B, A]\nDequeue stack: []\n";
        assertEquals(out, queue.toString());
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
        assertEquals("[]", queue.toString());
        assertNull(queue.dequeue());
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("A");
        out = "Enqueue stack: [A, B, C]\nDequeue stack: []\n";
        assertEquals(out, queue.toString());
        queue.dequeue();
        out = "Enqueue stack: []\nDequeue stack: [B, A]\n";
        assertEquals(out, queue.toString());
        queue.dequeue();
        out = "Enqueue stack: []\nDequeue stack: [A]\n";
        assertEquals(out, queue.toString());
    }

}