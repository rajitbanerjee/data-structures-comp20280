package maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for TreeMap.
 *
 * @author Rajit Banerjee, 18202817
 */

class TreeMapTest {
    @Test
    void testBasic() {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Integer[] arr = {44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80};
        for (Integer i : arr) {
            treeMap.put(i, i);
        }
        assertEquals(44, treeMap.get(44));
        // keySet() and values() should have elements in ascending order
        assertEquals("[8, 17, 21, 28, 29, 32, 44, 54, 65, 76, 80, 82, 88, 93, 97]",
                treeMap.keySet().toString());
        assertEquals("[8, 17, 21, 28, 29, 32, 44, 54, 65, 76, 80, 82, 88, 93, 97]",
                treeMap.values().toString());
        assertEquals(15, treeMap.size());
        // Test SortedMap ADT functions
        assertEquals("<8, 8>", treeMap.firstEntry().toString());
        assertEquals("<97, 97>", treeMap.lastEntry().toString());
        assertEquals("<44, 44>", treeMap.ceilingEntry(43).toString());
        assertEquals("<44, 44>", treeMap.floorEntry(45).toString());
        assertEquals("<32, 32>", treeMap.lowerEntry(44).toString());
        assertEquals("<54, 54>", treeMap.higherEntry(44).toString());
        assertEquals("<82, 82>", treeMap.lowerEntry(88).toString());
        assertEquals("<93, 93>", treeMap.higherEntry(88).toString());
        assertEquals("[<76, 76>, <80, 80>, <82, 82>, <88, 88>, <93, 93>]",
                treeMap.subMap(76, 97).toString());
        // Remove key 44 from the tree
        assertEquals(44, treeMap.remove(44));
        assertEquals("[8, 17, 21, 28, 29, 32, 54, 65, 76, 80, 82, 88, 93, 97]",
                treeMap.keySet().toString());
        assertEquals("[8, 17, 21, 28, 29, 32, 54, 65, 76, 80, 82, 88, 93, 97]",
                treeMap.values().toString());
        // Test BinaryTreePrinter
        treeMap = new TreeMap<>();
        treeMap.put(0, 0);
        treeMap.put(-1, -1);
        treeMap.put(1, 1);
        assertEquals("\n          0           \n" +
                "    ┌─────┴─────┐     \n" +
                "    -1          1     \n" +
                " ┌──┴──┐     ┌──┴──┐  \n" +
                "null  null  null  null\n", treeMap.toString());
    }

}