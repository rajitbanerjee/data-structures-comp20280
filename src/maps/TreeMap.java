package maps;

import interfaces.Entry;
import interfaces.Position;
import trees.BalanceableBinaryTree;
import trees.BinaryTreePrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * An implementation of a sorted map using a binary search tree.
 * <p>
 * 1. Implements SortedMap ADT functions: firstEntry(), lastEntry(), ceilingEntry(k),
 * floorEntry(k), lowerEntry(k), higherEntry(k), subMap(k1, k2)
 * <p>
 * 2. Implements Map ADT functions: size(), get(k), put(k, v), remove(k), entrySet()
 * <p>
 * 3. Additional public method: toString() to use BinaryTreePrinter to display the TreeMap.
 * <p>
 * 4. Other Map ADT functions: isEmpty(), keySet(), values() are already implemented in
 * AbstractMap, the parent of AbstractSortedMap.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class TreeMap<K, V> extends AbstractSortedMap<K, V> {
    private final BalanceableBinaryTree<K, V> tree = new BalanceableBinaryTree<>();

    /**
     * Constructs an empty map using the natural ordering of keys.
     */
    public TreeMap() {
        super(); // the AbstractSortedMap constructor
        tree.addRoot(null); // create a sentinel leaf as root
    }

    /**
     * Constructs an empty map using given comparator.
     *
     * @param comp custom Comparator
     */
    public TreeMap(Comparator<K> comp) {
        super(comp); // the AbstractSortedMap constructor
        tree.addRoot(null); // create a sentinel leaf as root
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        Integer[] arr = {44, 17, 88, 8, 32, 65, 97, 28, 54, 82, 93, 21, 29, 76, 80};
        System.out.println("TEST 1, fixed tree entries:");
        for (Integer i : arr) {
            treeMap.put(i, i);
        }
        System.out.println("Tree keys: " + treeMap.keySet());
        System.out.println(treeMap);
        System.out.println("Size: " + treeMap.size());
        System.out.println("Value at key 44: " + treeMap.get(44));
        System.out.println("First entry: " + treeMap.firstEntry());
        System.out.println("Last entry: " + treeMap.lastEntry());
        System.out.println("Ceiling entry for non-existent key 43: " + treeMap.ceilingEntry(43));
        System.out.println("Floor entry for non-existent key 45: " + treeMap.floorEntry(45));
        System.out.println("Lower entry for key 44: " + treeMap.lowerEntry(44));
        System.out.println("Higher entry for key 44: " + treeMap.higherEntry(44));
        System.out.println("Sub-map from key [76, 97) upper bound non-inclusive: " + treeMap.subMap(76, 97));
        System.out.println("Removed value at key 44: " + treeMap.remove(44));
        System.out.println("Tree keys after removal: " + treeMap.keySet());
        System.out.println(treeMap);

        System.out.println("TEST 2, random tree entries:");
        treeMap = new TreeMap<>();
        Random rnd = new Random();
        int n = 10;
        java.util.List<Integer> rands = rnd.ints(1, 1000).
                limit(n).distinct().boxed().collect(Collectors.toList());
        for (Integer i : rands) {
            treeMap.put(i, i);
        }
        System.out.println("Tree entries: " + treeMap.entrySet());
        System.out.println(treeMap);
        System.out.println("Removed value: " + treeMap.remove(rands.get(1)));
        System.out.println("Tree entries after removal: " + treeMap.entrySet());
        System.out.println(treeMap);
    }

    /**
     * Uses BinaryTreePrinter to represent the TreeMap.
     *
     * @return String representation of the TreeMap
     */
    @Override
    public String toString() {
        BinaryTreePrinter<Entry<K, V>> btp = new BinaryTreePrinter<>(tree);
        return btp.toString();
    }

    // Protected shorthand utilities
    protected Position<Entry<K, V>> root() {
        return tree.root();
    }

    protected Position<Entry<K, V>> parent(Position<Entry<K, V>> p) {
        return tree.parent(p);
    }

    protected Position<Entry<K, V>> left(Position<Entry<K, V>> p) {
        return tree.left(p);
    }

    protected Position<Entry<K, V>> right(Position<Entry<K, V>> p) {
        return tree.right(p);
    }

    protected Position<Entry<K, V>> sibling(Position<Entry<K, V>> p) {
        return tree.sibling(p);
    }

    protected boolean isRoot(Position<Entry<K, V>> p) {
        return tree.isRoot(p);
    }

    protected boolean isExternal(Position<Entry<K, V>> p) {
        return tree.isExternal(p);
    }

    protected boolean isInternal(Position<Entry<K, V>> p) {
        return tree.isInternal(p);
    }

    protected void set(Position<Entry<K, V>> p, Entry<K, V> e) {
        tree.set(p, e);
    }

    protected Entry<K, V> remove(Position<Entry<K, V>> p) {
        return tree.remove(p);
    }

    protected void rotate(Position<Entry<K, V>> p) {
        tree.rotate(p);
    }

    protected Position<Entry<K, V>> restructure(Position<Entry<K, V>> x) {
        return tree.restructure(x);
    }

    // Returns the position in p's subtree having the given key (or else the terminal leaf)
    protected Position<Entry<K, V>> treeSearch(Position<Entry<K, V>> p, K key) {
        if (isExternal(p)) {
            return p;
        } else {
            int c = compare(key, p.getElement());
            if (c == 0) {
                return p;
            } else if (c < 0) {
                return treeSearch(left(p), key);
            } else {
                return treeSearch(right(p), key);
            }
        }
    }

    // Returns position with the minimal key in the subtree rooted at Position p
    protected Position<Entry<K, V>> treeMin(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> temp = p;
        while (isInternal(temp)) {
            temp = left(temp);
        }
        return parent(temp);
    }

    // Returns position with the maximum key in the subtree rooted at Position p
    protected Position<Entry<K, V>> treeMax(Position<Entry<K, V>> p) {
        Position<Entry<K, V>> temp = p;
        while (isInternal(temp)) {
            temp = right(temp);
        }
        return parent(temp);
    }

    // Trivial re-balancing hooks that AVLTreeMap and SplayTreeMap can override
    protected void rebalanceInsert(Position<Entry<K, V>> p) {
    }

    protected void rebalanceDelete(Position<Entry<K, V>> p) {
    }

    protected void rebalanceAccess(Position<Entry<K, V>> p) {
    }

    // Implement Map ADT functions

    /**
     * Returns the number of entries in the map.
     *
     * @return number of entries in the map
     */
    @Override
    public int size() {
        return (tree.size() - 1) / 2; // only internal nodes have entries
    }

    /**
     * Returns the value associated with the specified key, or null if no such entry
     * exists.
     *
     * @param key the key whose associated value is to be returned
     * @return the associated value, or null if no such entry exists
     */
    @Override
    public V get(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        rebalanceAccess(p);
        if (isExternal(p)) {
            return null;
        } else {
            return p.getElement().getValue();
        }
    }

    /**
     * Associates the given value with the given key. If an entry with the key was
     * already in the map, this replaced the previous value with the new one and
     * returns the old value. Otherwise, a new entry is added and null is returned.
     *
     * @param key   key with which the specified value is to be associated
     * @param value value to be associated with the specified key
     * @return the previous value associated with the key (or null, if no such
     * entry)
     */
    @Override
    public V put(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new MapEntry<>(key, value);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
            expandExternal(p, newest);
            rebalanceInsert(p);
            return null;
        } else {
            V replaced = p.getElement().getValue();
            set(p, newest);
            rebalanceAccess(p);
            return replaced;
        }
    }

    // Utility used when inserting a new entry at a leaf of the tree
    private void expandExternal(Position<Entry<K, V>> p, Entry<K, V> entry) {
        tree.set(p, entry);
        tree.addLeft(p, null);
        tree.addRight(p, null);
    }

    /**
     * Removes the entry with the specified key, if present, and returns its
     * associated value. Otherwise does nothing and returns null.
     *
     * @param key the key whose entry is to be removed from the map
     * @return the previous value associated with the removed key, or null if no
     * such entry exists
     */
    @Override
    public V remove(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isExternal(p)) {
            rebalanceAccess(p);
            return null;
        } else {
            V removed = p.getElement().getValue();
            if (isInternal(left(p)) && isInternal(right(p))) {
                Position<Entry<K, V>> r = treeMax(left(p));
                set(p, r.getElement());
                p = r;
            }
            Position<Entry<K, V>> leaf = isExternal(left(p)) ? left(p) : right(p);
            Position<Entry<K, V>> sibling = sibling(leaf);
            remove(leaf);
            remove(p);
            rebalanceDelete(sibling);
            return removed;
        }
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> temp = new ArrayList<>(size());
        for (Position<Entry<K, V>> p : tree.inorder()) {
            if (isInternal(p)) {
                temp.add(p.getElement());
            }
        }
        return temp;
    }

    // additional behaviors of the SortedMap ADT

    /**
     * Returns the entry having the least key (or null if map is empty).
     *
     * @return entry with least key (or null if map is empty)
     */
    @Override
    public Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return treeMin(root()).getElement();
    }

    /**
     * Returns the entry having the greatest key (or null if map is empty).
     *
     * @return entry with greatest key (or null if map is empty)
     */
    @Override
    public Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return treeMax(root()).getElement();
    }

    /**
     * Returns the entry with least key greater than or equal to given key (or null
     * if no such key exists).
     *
     * @param key given key whose ceiling entry is required
     * @return entry with least key greater than or equal to given (or null if no
     * such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> ceilingEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p)) {
            return p.getElement();
        }
        while (!isRoot(p)) {
            if (p == left(parent(p))) {
                return parent(p).getElement();
            } else {
                p = parent(p);
            }
        }
        return null;
    }

    /**
     * Returns the entry with greatest key less than or equal to given key (or null
     * if no such key exists).
     *
     * @param key given key whose floor entry is required
     * @return entry with greatest key less than or equal to given (or null if no
     * such entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> floorEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p)) {
            return p.getElement();
        }
        while (!isRoot(p)) {
            if (p == right(parent(p))) {
                return parent(p).getElement();
            } else {
                p = parent(p);
            }
        }
        return null;
    }

    /**
     * Returns the entry with greatest key strictly less than given key (or null if
     * no such key exists).
     *
     * @param key given key whose lower entry is required
     * @return entry with greatest key strictly less than given (or null if no such
     * entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> lowerEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p) && isInternal(left(p))) {
            return treeMax(left(p)).getElement();
        }
        while (!isRoot(p)) {
            if (p == right(parent(p))) {
                return parent(p).getElement();
            } else {
                p = parent(p);
            }
        }
        return null;
    }

    /**
     * Returns the entry with least key strictly greater than given key (or null if
     * no such key exists).
     *
     * @param key given key whose higher entry it required
     * @return entry with least key strictly greater than given (or null if no such
     * entry)
     * @throws IllegalArgumentException if the key is not compatible with the map
     */
    @Override
    public Entry<K, V> higherEntry(K key) throws IllegalArgumentException {
        checkKey(key);
        Position<Entry<K, V>> p = treeSearch(root(), key);
        if (isInternal(p) && isInternal(right(p))) {
            return treeMin(right(p)).getElement();
        }
        while (!isRoot(p)) {
            if (p == left(parent(p))) {
                return parent(p).getElement();
            } else {
                p = parent(p);
            }
        }
        return null;
    }

    /**
     * Returns an iterable containing all entries with keys in the range from
     * <code>fromKey</code> inclusive to <code>toKey</code> exclusive.
     *
     * @param fromKey key starting at which the sub map is required
     * @param toKey   key ending at which the sub map is required
     * @return iterable with keys in desired range
     * @throws IllegalArgumentException if <code>fromKey</code> or
     *                                  <code>toKey</code> is not compatible with
     *                                  the map
     */
    @Override
    public Iterable<Entry<K, V>> subMap(K fromKey, K toKey) throws IllegalArgumentException {
        ArrayList<Entry<K, V>> temp = new ArrayList<>(size());
        if (compare(fromKey, toKey) < 0) {
            fillSubMap(fromKey, toKey, root(), temp);
        }
        return temp;
    }

    // Recursively fill the entries in the given range
    private void fillSubMap(K fromKey, K toKey, Position<Entry<K, V>> p, ArrayList<Entry<K, V>> temp) {
        if (isInternal(p)) {
            if (compare(p.getElement(), fromKey) < 0) {
                fillSubMap(fromKey, toKey, right(p), temp);
            } else {
                fillSubMap(fromKey, toKey, left(p), temp);
                if (compare(p.getElement(), toKey) < 0) {
                    temp.add(p.getElement());
                    fillSubMap(fromKey, toKey, right(p), temp);
                }
            }
        }
    }

}