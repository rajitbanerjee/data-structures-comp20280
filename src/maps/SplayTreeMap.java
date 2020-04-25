package maps;

import interfaces.Entry;
import interfaces.Position;
import trees.BalanceableBinaryTree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * An implementation of a sorted map using a splay tree.
 * <p>
 * All Map ADT and SortedMap ADT functions are inherited from TreeMap.
 * <p>
 * The purpose of this class is to override the template implementations of rebalanceInsert,
 * rebalanceDelete and rebalanceAccess methods from TreeMap, in order to splay the tree's
 * bottom-most position after node insertion, deletion and access operations.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class SplayTreeMap<K, V> extends TreeMap<K, V> {
    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public SplayTreeMap() {
        super();
    }

    /**
     * Constructs an empty map using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the map
     */
    public SplayTreeMap(Comparator<K> comp) {
        super(comp);
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ SplayTreeMap ~");
        SplayTreeMap<Integer, Integer> map = new SplayTreeMap<>();
        Integer[] arr = {44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80};
        for (Integer i : arr) {
            map.put(i, i);
        }
        System.out.println("To insert: " + Arrays.toString(arr));
        System.out.println("Splay Tree keys after insertion: " + map.keySet());
        System.out.println(map);

        System.out.println("After removing " + map.remove(arr[0]) + ": " + map);

        // Check if splay operation works for frequently accessed keys
        System.out.println("Value at key 88: " + map.get(88));
        System.out.println("After first search for key 88: " + map);

        System.out.println("Value at key 65: " + map.get(65));
        System.out.println("After first search for key 65: " + map);

        System.out.println("Value at key 88: " + map.get(88));
        System.out.println("After second search for key 88: " + map);

        System.out.println("Value at key 65: " + map.get(65));
        System.out.println("After second search for key 65: " + map);
    }

    // Re-balances the tree after node insertion
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        splay(p);
    }

    // Re-balances the tree after node deletion
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            splay(parent(p));
        }
    }

    // Re-balances the tree after node access
    @Override
    protected void rebalanceAccess(Position<Entry<K, V>> p) {
        if (isExternal(p)) {
            p = parent(p);
        }
        if (p != null) {
            splay(p);
        }
    }

    // Utility used to rebalance after a map operation.
    private void splay(Position<Entry<K, V>> p) {
        while (!isRoot(p)) {
            boolean zig = (parent(parent(p)) == null);
            boolean zigZig = !zig &&
                    (parent(p) == left(parent(parent(p)))) == (p == left(parent(p)));
            // Splay the position p for zig, zig-zig and zig-zag cases
            if (zig) {
                rotate(p);
            } else if (zigZig) {
                rotate(parent(p));
                rotate(p);
            } else { // zig zag
                rotate(p);
                rotate(p);
            }
        }
    }

}