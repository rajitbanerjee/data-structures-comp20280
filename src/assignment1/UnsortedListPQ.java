package assignment1;

import lists.DoublyLinkedList;
import projectCode20280.AbstractPriorityQueue;
import projectCode20280.Entry;

/**
 * Assignment 1, Question 5.
 * Implement a PriorityQueue using an unsorted DoublyLinkedList.
 *
 * @param <K> generic type of PQ entry keys
 * @param <V> generic type of PQ entry values
 * @author Rajit Banerjee, 18202817
 */
public class UnsortedListPQ<K, V> extends AbstractPriorityQueue<K, V> {
    protected DoublyLinkedList<Entry<K, V>> list = new DoublyLinkedList<>();

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
        list.addLast(newest);
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
     * Returns the index of the minimum key element in the PriorityQueue.
     *
     * @return integer value of the index of minimum key element
     */
    public int minIndex() {
        if (list.isEmpty()) {
            return -1;
        }
        int min = 0;
        for (int i = 0; i < list.size(); i++) {
            Entry<K, V> current = list.get(i);
            Entry<K, V> smallest = list.get(min);
            if (compare(current, smallest) < 0) {
                min = i;
            }

        }
        return min;
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
        int smallest = minIndex();
        Entry<K, V> minimum = list.get(smallest);
        list.remove(smallest);
        return minimum;
    }

}