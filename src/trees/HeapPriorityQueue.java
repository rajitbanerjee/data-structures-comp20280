package trees;

import projectCode20280.AbstractPriorityQueue;
import projectCode20280.Entry;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * An implementation of a priority queue using an array-based heap.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class HeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> heap = new ArrayList<>();

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
     * Creates a priority queue initialized with the respective
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
        int i = 0;
        while (i++ < Math.min(keys.length, values.length)) {
            heap.add(new PQEntry<>(keys[i], values[i]));
        }
        heapify();
    }

    /**
     * Performs a bottom-up construction of the heap in linear time.
     */
    protected void heapify() {
        int index = size() - 1;
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
     * Exchanges the entries at indices i and j of the array list.
     */
    protected void swap(int i, int j) {
        Entry<K, V> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    /**
     * Moves the entry at index j higher, if necessary, to restore the heap property.
     */
    protected void upheap(int j) {
        while (j != 0 && compare(heap.get(j), heap.get(parent(j))) < 0) {
            swap(j, parent(j));
            j = parent(j);
        }
    }

    /**
     * Moves the entry at index j lower, if necessary, to restore the heap property.
     */
    protected void downheap(int j) {
        int minChildIndex = -1;
        while (hasLeft(j) && compare(heap.get(minChildIndex), heap.get(j)) < 0) {
            if (hasRight(j)) {
                minChildIndex = (compare(heap.get(left(j)), heap.get(right(j))) <= 0) ?
                        left(j) : right(j);
            } else {
                minChildIndex = left(j);
            }
            swap(j, minChildIndex);
            j = minChildIndex;
        }
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
        heap.add(newest);
        upheap(size() - 1);
        return newest;
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
     * Used for debugging purposes only.
     */
    private void sanityCheck() {
        for (int j = 0; j < size(); j++) {
            int left = left(j);
            int right = right(j);
            if (left < size() && compare(heap.get(left), heap.get(j)) < 0)
                System.out.println("Invalid left child relationship");
            if (right < size() && compare(heap.get(right), heap.get(j)) < 0)
                System.out.println("Invalid right child relationship");
        }
    }
}

