package maps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for UnsortedTableMap.
 *
 * @author Aonghus Lawlor
 * @author Rajit Banerjee, 18202817
 */

class UnsortedTableMapTest2 {

    @Test
    void testSize() {
        UnsortedTableMap<Integer, String> map = new UnsortedTableMap<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(i, Integer.toString(i));
        }
        assertEquals(n, map.size());
    }

    @Test
    void testGet() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(Integer.toString(i), i);
        }
        assertEquals(5, map.get("5"));
        assertEquals(2, map.get("2"));
    }

    @Test
    void testRemove() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(Integer.toString(i), i);
        }
        assertEquals(5, map.remove("5"));
        assertEquals(n - 1, map.size());
    }

    @Test
    void testPut() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(Integer.toString(i), i);
        }
        assertEquals(n, map.size());
    }

    @Test
    void testIsEmpty() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        assertTrue(map.isEmpty());
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(Integer.toString(i), i);
        }
        assertFalse(map.isEmpty());
    }

    @Test
    void testKeySet() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        ArrayList<String> buf = new ArrayList<>();
        for (String s : map.keySet()) buf.add(s);
        buf.sort(String::compareTo);
        assertEquals("[one, three, two]", buf.toString());
    }

    @Test
    void testValues() {
        UnsortedTableMap<String, Integer> map = new UnsortedTableMap<>();
        int n = 10;
        for (int i = 0; i < n; ++i) {
            map.put(Integer.toString(i), i);
        }
        ArrayList<Integer> buf = new ArrayList<>();
        for (Integer s : map.values()) buf.add(s);
        buf.sort(Integer::compareTo);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", buf.toString());
    }

}