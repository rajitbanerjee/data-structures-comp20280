package trees;

import projectCode20280.AbstractPriorityQueue;
import projectCode20280.Entry;

import java.util.ArrayList;

public class UnsortedListPQ<K, V> extends AbstractPriorityQueue<K, V> {
    protected ArrayList<Entry<K, V>> list = new ArrayList<>();

    /**
     * Returns the number of items in the priority queue.
     *
     * @return number of items
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Inserts a key-value pair and returns the entry created.
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
        list.add(newest);
        return newest;
    }

    /**
     * Returns (but does not remove) an entry with minimal key.
     *
     * @return entry having a minimal key (or null if empty)
     */
    @Override
    public Entry<K, V> min() {
        if (list.isEmpty()) {
            return null;
        }
        Entry<K, V> smallest = list.get(0);
        for (Entry<K, V> current : list) {
            if (compare(current, smallest) < 0) {
                smallest = current;
            }
        }
        return smallest;
    }

    /**
     * Removes and returns an entry with minimal key.
     *
     * @return the removed entry (or null if empty)
     */
    @Override
    public Entry<K, V> removeMin() {
        if (list.isEmpty()) {
            return null;
        }
        Entry<K, V> smallest = min();
        list.remove(smallest);
        return smallest;
    }

}
