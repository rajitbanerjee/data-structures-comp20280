package lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for CircularlyLinkedList.
 *
 * @author Rajit Banerjee, 18202817
 */

class CircularlyLinkedListTest {
    private CircularlyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new CircularlyLinkedList<>();
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

    @Test
    void testGetAtIndex() {
        assertNull(list.get(2));
        list.addLast("A");
        list.addFirst("B");
        list.addLast("C");
        assertEquals("B", list.get(0));
        assertEquals("A", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void testRemoveFirst() {
        assertNull(list.removeFirst());
        list.addFirst("A");
        list.addFirst("B");
        list.removeFirst();
        assertEquals("[A]", list.toString());
        list.removeFirst();
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveLast() {
        assertNull(list.removeLast());
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        assertEquals("[C, B, A]", list.toString());
        list.removeLast();
        assertEquals("[C, B]", list.toString());
        list.removeLast();
        assertEquals("[C]", list.toString());
        list.removeLast();
        assertEquals("[]", list.toString());
    }

    @Test
    void testRemoveIndex() {
        assertNull(list.remove(0));
        assertNull(list.remove(1));
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

    @Test
    void testRotate() {
        list.addFirst("A");
        list.addFirst("B");
        list.addFirst("C");
        list.addFirst("D");
        assertEquals("[D, C, B, A]", list.toString());
        list.rotate();
        assertEquals("[C, B, A, D]", list.toString());
        list.rotate();
        assertEquals("[B, A, D, C]", list.toString());
    }

    @Test
    void lab1Tests() {
        // TEST 1: Given in skeleton code
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        CircularlyLinkedList<String> cll = new CircularlyLinkedList<>();
        for (String s : alphabet) {
            cll.addFirst(s);
            cll.addLast(s);
        }
        assertEquals("[Z, Y, X, W, V, U, T, S, R, Q, P, O, " +
                "N, M, L, K, J, I, H, G, F, E, D, C, B, A, A, B, C, " +
                "D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, " +
                "U, V, W, X, Y, Z]", cll.toString());

        cll.removeFirst();
        assertEquals("[Y, X, W, V, U, T, S, R, Q, P, O, N, M, " +
                "L, K, J, I, H, G, F, E, D, C, B, A, A, B, C, D, E, F, " +
                "G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, " +
                "Y, Z]", cll.toString());

        cll.removeLast();
        assertEquals("[Y, X, W, V, U, T, S, R, Q, P, O, N, M, L, " +
                "K, J, I, H, G, F, E, D, C, B, A, A, B, C, D, E, F, G, H, " +
                "I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]", cll.toString());

        cll.remove(2);
        assertEquals("[Y, X, V, U, T, S, R, Q, P, O, N, M, L, K, J, " +
                "I, H, G, F, E, D, C, B, A, A, B, C, D, E, F, G, H, I, J, " +
                "K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y]", cll.toString());

        int i = 0;
        for (String s : cll) {
            assertEquals(cll.get(i), s);
            i++;
        }

        // TEST 2: Given in practical 1
        CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<>();
        ll.addFirst(0);
        ll.addFirst(1);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.addFirst(5);
        ll.add(3, 2);
        assertEquals("[5, 4, 3, 2, 1, 0]", ll.toString());

        ll.addFirst(-100);
        ll.addLast(+100);
        assertEquals("[-100, 5, 4, 3, 2, 1, 0, 100]", ll.toString());
        ll.removeFirst();
        ll.removeLast();
        assertEquals("[5, 4, 3, 2, 1, 0]", ll.toString());
        // Removes the item in the specified index ll.remove(2); System.out.println(ll);
        ll.removeFirst();
        assertEquals("[4, 3, 2, 1, 0]", ll.toString());
        ll.removeLast();
        assertEquals("[4, 3, 2, 1]", ll.toString());
        ll.removeFirst();
        assertEquals("[3, 2, 1]", ll.toString());
        ll.addFirst(9999);
        ll.addFirst(8888);
        ll.addFirst(7777);

        assertEquals("[7777, 8888, 9999, 3, 2, 1]", ll.toString());
        assertEquals(7777, ll.get(0));
        assertEquals(8888, ll.get(1));
        assertEquals(9999, ll.get(2));
        assertEquals("[7777, 8888, 9999, 3, 2, 1]", ll.toString());
    }

}