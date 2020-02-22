package projectCode20280;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.spec.ECField;

import static org.junit.jupiter.api.Assertions.*;

class ArrayQueueTest {
    private Queue<String> queue;

    @BeforeEach
    void setUp() {
        queue = new ArrayQueue<>();
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

    @Test void testOverflow() {
        queue = new ArrayQueue<>(3);
        queue.enqueue("A");
        queue.enqueue("A");
        queue.enqueue("A");
        try {
            queue.enqueue("A");
            fail("Queue capacity reached!");
        } catch (Exception ignored) {
            // test passed
        }
    }

    @Test
    void testFirst() {
        queue.enqueue("C");
        queue.enqueue("B");
        queue.enqueue("A");
        assertEquals("C", queue.first());
        queue.enqueue("F");
        assertEquals("C", queue.first());
    }

    @Test
    void testDequeue() {
        try {
            queue.dequeue();
            fail("Queue is empty!");
        } catch (Exception ignored) {
            // test passed
        }
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
