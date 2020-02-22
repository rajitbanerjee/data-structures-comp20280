
package projectCode20280;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private DoublyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new DoublyLinkedList<>();
    }

    @Test
    void testSizeAndIsEmpty() {
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    void testAddFirst() {
        list.addFirst("A");
        assertEquals("[A]", list.toString());
        list.addFirst("B");
        assertEquals("[B, A]", list.toString());
    }

    @Test
    void testAddLast() {
        list.addLast("A");
        assertEquals("[A]", list.toString());
        list.addLast("B");
        assertEquals("[A, B]", list.toString());
    }

    @Test
    void testAddAtIndex() {
        try {
            list.add(0, "C");
            list.add(0, "A");
            list.add(1, "B");
            list.add(1, "D");
            list.add(4, "E");
            assertEquals("[A, D, B, C, E]", list.toString());
        } catch (Exception e) {
            fail("Add at given index not working.");
        }
        try {
            list.add(10, "F");
            fail("List index out of bounds!");
        } catch (Exception ignored) {
            // test passed
        }
    }

    @Test void testFirst() {
        assertNull(list.first());
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals("A", list.first());
        list.addFirst("F");
        assertEquals("F", list.first());
    }

    @Test void testLast() {
        assertNull(list.last());
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        assertEquals("C", list.last());
        list.addLast("F");
        assertEquals("F", list.last());
    }

    @Test
    void testGetAtIndex() {
        try {
            list.get(2);
            list.addFirst("A");
            list.get(1);
            fail("List index out of bounds!");
        } catch (Exception e) {
            // test passed
        }
        list.addLast("A");
        list.addFirst("B");
        list.addLast("C");
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testRemoveFirst() {
        try {
            list.removeFirst();
            fail("List is empty!");
        } catch (Exception ignored) {
            // test passed
        }
        list.addFirst("A");
        list.addFirst("B");
        list.removeFirst();
        assertEquals("[A]", list.toString());
        list.removeFirst();
        assertEquals(0, list.size());
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveLast() {
        try {
            list.removeLast();
            fail("List is empty!");
        } catch (Exception ignored) {
            // test passed
        }
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.removeLast();
        assertEquals("[C, B]", list.toString());
        list.removeLast();
        assertEquals("[C]", list.toString());
        list.removeLast();
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveIndex() {
        try {
            list.remove(0);
            list.addFirst("A");
            list.remove(1);
            fail("List index is out of bounds!");
        } catch (Exception ignored) {
            // test passed
        }
        assertEquals("[]", list.toString());
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        assertEquals("[D, C, B, A]", list.toString());
        list.remove(2);
        assertEquals("[D, C, A]", list.toString());
        list.remove(1);
        assertEquals(2, list.size());
        assertEquals("[D, A]", list.toString());
        list.remove(1);
        assertEquals("[D]", list.toString());
        list.remove(0);
        assertEquals("[]", list.toString());
    }

}
