package projectCode20280;

import java.util.Comparator;

/**
 * An abstract base class to ease the implementation of the PriorityQueue interface.
 * <p>
 * The base class provides four means of support:
 * 1) It defines a PQEntry class as a concrete implementation of the
 * entry interface
 * 2) It provides an instance variable for a general Comparator and a
 * protected method, compare(a, b), that makes use of the comparator.
 * 3) It provides a boolean checkKey method that verifies that a given key
 * is appropriate for use with the comparator
 * 4) It provides an isEmpty implementation based upon the abstract size() method.
 */
public abstract class AbstractPriorityQueue<K, V> implements PriorityQueue<K, V> {
    //---------------- nested PQEntry class ----------------

    /**
     * The comparator defining the ordering of keys in the priority queue.
     */
    private Comparator<K> comp;

    // instance variable for an AbstractPriorityQueue

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
    protected AbstractPriorityQueue() {
        this(new DefaultComparator<>());
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

        // methods of the Entry interface
        public K getKey() {
            return key;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        protected void setValue(V value) {
            this.value = value;
        }

        /**
         * Returns a String representation of the object
         *
         * @return a String representation of the object
         */
        @Override
        public String toString() {
            return "(" + key.toString() + ", " + value.toString() + ")";
        }
    } //----------- end of nested PQEntry class -----------

}