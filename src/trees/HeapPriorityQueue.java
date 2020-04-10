package trees;

import lists.DoublyLinkedList;
import projectCode20280.Entry;

import java.util.Comparator;

/**
 * An implementation of a priority queue using a linked-based/array-based heap.
 * <p>
 * 1. Implements PriorityQueue ADT: size(), insert(K key, V value), min(), removeMin()
 * 2. isEmpty() from PriorityQueue ADT is already implemented in AbstractPriorityQueue.
 * 3. Additional public method: toString()
 * 4. Allows bottom-up heap construction from provided key-value pair arrays, or regular construction
 * using up-heap bubbling.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected DoublyLinkedList<Entry<K, V>> heap = new DoublyLinkedList<>();

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    public HeapPriorityQueue() {
        super();
    }

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    public HeapPriorityQueue(Comparator<K> comp) {
        super(comp);
    }

    /**
     * Creates a priority queue initialised with the respective
     * key-value pairs.  The two arrays given will be paired
     * element-by-element. They are presumed to have the same
     * length. (If not, entries will be created only up to the length of
     * the shorter of the arrays).
     *
     * @param keys   an array of the initial keys for the priority queue
     * @param values an array of the initial values for the priority queue
     */
    public HeapPriorityQueue(K[] keys, V[] values) {
        super();
        for (int i = 0; i < Math.min(keys.length, values.length); i++) {
            heap.addLast(new PQEntry<>(keys[i], values[i]));
        }
        heapify();
    }

    /**
     * Performs a bottom-up construction of the heap in linear time.
     */
    protected void heapify() {
        int index = parent(size() - 1);
        while (index >= 0) {
            downheap(index);
            index--;
        }
    }

    protected int parent(int j) {
        return (j - 1) / 2;
    }

    protected int left(int j) {
        return 2 * j + 1;
    }

    protected int right(int j) {
        return 2 * j + 2;
    }

    protected boolean hasLeft(int j) {
        return size() > left(j);
    }

    protected boolean hasRight(int j) {
        return size() > right(j);
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     */
    protected void downheap(int j) {
        int minChildIndex;
        while (hasLeft(j)) {
            if (hasRight(j) && (compare(heap.get(left(j)), heap.get(right(j))) > 0)) {
                minChildIndex = right(j);
            } else {
                minChildIndex = left(j);
            }
            if (compare(heap.get(minChildIndex), heap.get(j)) >= 0) {
                break;
            }
            swap(j, minChildIndex);
            j = minChildIndex;
        }
    }

    /**
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() {
        return heap.size();
    }

    /**
     * Inserts a key-value pair and return the entry created.
     *
     * @param key   the key of the new entry
     * @param value the associated value of the new entry
     * @return the entry storing the new key-value pair
     * @throws IllegalArgumentException if the key is unacceptable for this queue
     */
    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key);
        Entry<K, V> newest = new PQEntry<>(key, value);
        heap.addLast(newest);
        upheap(size() - 1);
        return newest;
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     */
    protected void upheap(int j) {
        while (j != 0) {
            int parent = parent(j);
            if (compare(heap.get(parent), heap.get(j)) < 0) {
                break;
            }
            swap(j, parent);
            j = parent;
        }
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("Test 1: Bottom-up construction");
        Integer[] keys = {5, 4, 3, 2, 1};
        Integer[] values = {5, 4, 3, 2, 1};
        HeapPriorityQueue<Integer, Integer> heap = new HeapPriorityQueue<>(keys, values);
        System.out.println("Insert 5, 4, 3, 2, 1: ");
        System.out.println(heap);

        System.out.println("\nMin (key, value): " + heap.min());
        System.out.println("After removeMin(): ");
        heap.removeMin();
        System.out.println(heap);

        System.out.println("\nMin (key, value): " + heap.min());
        System.out.println("After removeMin(): ");
        heap.removeMin();
        System.out.println(heap);

        System.out.println("\nTest 2: Up-heap bubbling insertion");
        heap = new HeapPriorityQueue<>();
        heap.insert(1, 1);
        heap.insert(2, 2);
        heap.insert(3, 3);
        heap.insert(0, 0);
        System.out.println("Insert 1, 2, 3, 0: ");
        System.out.println(heap);

        System.out.println("\nMin (key, value): " + heap.min());
        System.out.println("After removeMin(): ");
        heap.removeMin();
        System.out.println(heap);

        System.out.println("\nMin (key, value): " + heap.min());
        System.out.println("After removeMin(): ");
        heap.removeMin();
        System.out.println(heap);
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K, V> removeMin() {
        if (isEmpty()) {
            return null;
        } else {
            Entry<K, V> removed = heap.get(0);
            swap(0, size() - 1);
            heap.remove(heap.size() - 1);
            downheap(0);
            return removed;
        }
    }

    /**
     * Gets the String representation of the heap.
     *
     * @return String representation of the heap
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Entry<K, V> elem : heap) {
            sb.append(elem.getValue()).append(", ");
        }
        sb = new StringBuilder(sb.substring(0, sb.length() - 2));
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K, V> min() {
        if (isEmpty()) {
            return null;
        } else {
            return heap.get(0);
        }
    }

}