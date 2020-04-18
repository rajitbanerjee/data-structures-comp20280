package trees;

import interfaces.Entry;
import interfaces.PriorityQueue;

import java.util.Comparator;

/**
 * An abstract base class to ease the implementation of the PriorityQueue interface.
 * <p>
 * The base class provides four means of support:
 * 1) It defines a PQEntry class as a concrete implementation of the
 * entry interface.
 * <p>
 * 2) It provides an instance variable for a general Comparator and a
 * protected method, compare(a, b), that makes use of the comparator.
 * <p>
 * 3) It provides a boolean checkKey method that verifies that a given key
 * is appropriate for use with the comparator.
 * <p>
 * 4) It provides an isEmpty implementation based on the abstract size() method.
 */

public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {

    // The comparator defining the ordering of keys in the priority queue.
    private final Comparator<K> comp;

    /**
     * Creates an empty priority queue using the given comparator to order keys.
     *
     * @param comp comparator defining the order of keys in the priority queue
     */
    protected AbstractPriorityQueue(Comparator<K> comp) {
        this.comp = comp;
    }

    /**
     * Creates an empty priority queue based on the natural ordering of its keys.
     */
    @SuppressWarnings("unchecked")
    protected AbstractPriorityQueue() {
        this((k1, k2) -> ((Comparable<K>) k1).compareTo(k2));
    }

    /**
     * Method for comparing two entries according to key.
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Determines whether a key is valid.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            // see if key can be compared to itself
            return (comp.compare(key, key) == 0);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

    /**
     * Tests whether the priority queue is empty.
     *
     * @return true if the priority queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    //---------------- nested PQEntry class ----------------

    /**
     * A concrete implementation of the Entry interface to be used within
     * a PriorityQueue implementation.
     */
    protected static class PQEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public PQEntry(K key, V value) {
            setKey(key);
            setValue(value);
        }

        @Override
        public K getKey() {
            return key;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "<" + key + ", " + value + ">";
        }

    } //----------- end of nested PQEntry class -----------

}