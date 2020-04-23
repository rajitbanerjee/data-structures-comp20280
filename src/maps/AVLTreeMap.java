package maps;

import interfaces.Entry;
import interfaces.Position;
import trees.BalanceableBinaryTree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * An implementation of a sorted map using an AVL tree.
 * <p>
 * All Map ADT and SortedMap ADT functions are inherited from TreeMap.
 * <p>
 * The purpose of this class is to override the template implementations of
 * rebalanceInsert and rebalanceDelete methods from TreeMap, to balance the
 * binary tree after node insertion and deletion operations.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class AVLTreeMap<K, V> extends TreeMap<K, V> {
    protected BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public AVLTreeMap() {
        super();
    }

    /**
     * Constructs an empty map using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the map
     */
    public AVLTreeMap(Comparator<K> comp) {
        super(comp);
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        AVLTreeMap<Integer, Integer> avl = new AVLTreeMap<>();
        Integer[] arr = {44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80};
        for (Integer i : arr) {
            avl.put(i, i);
        }
        System.out.println("To insert: " + Arrays.toString(arr));
        System.out.println("AVL Tree keys after insertion: " + avl.keySet());
        System.out.println(avl);
        System.out.println("Sanity check: " + (avl.sanityCheck() ? "passed" : "failed"));

        System.out.println("After removing " + avl.remove(arr[0]) + ": " + avl);
        System.out.println("Sanity check: " + (avl.sanityCheck() ? "passed" : "failed"));
    }

    // Re-balances the tree after node insertion
    @Override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
        rebalance(p);
    }

    // Re-balances the tree after node deletion
    @Override
    protected void rebalanceDelete(Position<Entry<K, V>> p) {
        if (!isRoot(p)) {
            rebalance(parent(p));
        }
    }

    // Rebalance after an insert or removal operation
    private void rebalance(Position<Entry<K, V>> p) {
        int h1, h2;
        do {
            h1 = height(p);
            if (!isBalanced(p)) {
                // Perform tri-node restructuring until imbalance is removed
                p = restructure(tallerChild(tallerChild(p)));
                recomputeHeight(left(p));
                recomputeHeight(right(p));
            }
            h2 = recomputeHeight(p);
            p = parent(p);
        } while (h1 != h2 && p != null);
    }

    // Returns the height of the given tree position
    private int height(Position<Entry<K, V>> p) {
        return tree.getAux(p);
    }

    // Returns whether a position has balance factor between -1 and 1 inclusive
    protected boolean isBalanced(Position<Entry<K, V>> p) {
        int balanceFactor = height(left(p)) - height(right(p));
        return balanceFactor >= -1 && balanceFactor <= 1;
    }

    // Recomputes and returns the (new) height of the given position based on its children's heights
    private int recomputeHeight(Position<Entry<K, V>> p) {
        int leftHeight = height(left(p));
        int rightHeight = height(right(p));
        int newHeight = Math.max(leftHeight, rightHeight);
        tree.setAux(p, 1 + newHeight);
        return height(p);
    }

    // Returns a child of p with height no smaller than that of the other child
    private Position<Entry<K, V>> tallerChild(Position<Entry<K, V>> p) {
        int leftHeight = height(left(p));
        int rightHeight = height(right(p));
        if (leftHeight != rightHeight) {
            return (leftHeight > rightHeight ? left(p) : right(p));
        } else if (isRoot(p) || p == left(parent(p))) {
            return left(p);
        } else {
            return right(p);
        }
    }

    // Ensure that current tree structure is valid AVL (for debug use only)
    private boolean sanityCheck() {
        for (Position<Entry<K, V>> p : tree.positions()) {
            if (isInternal(p)) {
                if (p.getElement() == null)
                    System.out.println("VIOLATION: Internal node has null entry");
                else if (height(p) != 1 + Math.max(height(left(p)), height(right(p)))) {
                    System.out.println("VIOLATION: AVL unbalanced node with key " + p.getElement().getKey());
                    return false;
                }
            }
        }
        return true;
    }

}