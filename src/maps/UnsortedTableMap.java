package maps;

import interfaces.Entry;
import interfaces.Map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An implementation of a map using an unsorted table.
 * <p>
 * 1. Implements Map ADT functions: size(), get(k), put(k, v), remove(k), entrySet()
 * <p>
 * 2. Additional public method: toString()
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 * Reference: Data Structures and Algorithms (Goodrich, Tamassia, Goldwasser)
 */

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    // Underlying storage for the map of entries.
    private final ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    /**
     * Constructs an initially empty map.
     */
    public UnsortedTableMap() {
    }

    // Main method to perform basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ UnsortedTableMap ~");
        Map<Integer, String> m = new UnsortedTableMap<>();
        m.put(1, "One");
        m.put(10, "Ten");
        m.put(11, "Eleven");
        m.put(20, "Twenty");

        System.out.println("Initial map:");
        System.out.println("Map: " + m);
        System.out.println("Keys: " + m.keySet());
        System.out.println("Values: " + m.values());

        System.out.println("\nget(1): " + m.get(1));
        System.out.println("get(10): " + m.get(10));
        System.out.println("get(11): " + m.get(11));
        System.out.println("get(20): " + m.get(20));

        System.out.println("\nAfter remove(11):");
        m.remove(11);
        System.out.println("Map: " + m);
        System.out.println("Keys: " + m.keySet());
        System.out.println("Values: " + m.values());

        System.out.println("\nget(1): " + m.get(1));
        System.out.println("get(10): " + m.get(10));
        System.out.println("get(11): " + m.get(11));
        System.out.println("get(20): " + m.get(20));
    }

    // private utility

    // Returns the index of an entry with equal key, or -1 if none found.
    private int findIndex(K key) {
        for (int i = 0; i < size(); i++) {
            if (table.get(i).getKey().equals(key)) {
                return i;
            }
        }
        return -1;
    }

    // public methods

    /**
     * Returns the number of entries in the map.
     *
     * @return number of entries in the map
     */
    @Override
    public int size() {
        return table.size();
    }

    /**
     * Returns the value associated with the specified key, or null if no such entry
     * exists.
     *
     * @param key the key whose associated value is to be returned
     * @return the associated value, or null if no such entry exists
     */
    @Override
    public V get(K key) {
        int index = findIndex(key);
        return (index == -1) ? null : table.get(index).getValue();
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
    public V put(K key, V value) {
        int index = findIndex(key);
        if (index != -1) {
            return table.get(index).setValue(value);
        } else {
            table.add(new MapEntry<>(key, value));
            return null;
        }
    }

    /**
     * Removes the entry with the specified key, if present, and returns its value.
     * Otherwise does nothing and returns null.
     *
     * @param key the key whose entry is to be removed from the map
     * @return the previous value associated with the removed key, or null if no
     * such entry exists
     */
    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1) {
            return null;
        } else {
            V removed = table.get(index).getValue();
            if (index != size() - 1) {
                table.set(index, table.get(size() - 1));
            }
            table.remove(size() - 1);
            return removed;
        }
    }

    /**
     * Gets the String representation of the UnsortedTableMap.
     *
     * @return String representation of the UnsortedTableMap
     */
    @Override
    public String toString() {
        return table.toString();
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }

    // ---------------- nested EntryIterable class ----------------
    private class EntryIterable implements Iterable<Entry<K, V>> {
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    } // ----------- end of nested EntryIterable class -----------

    // ---------------- nested EntryIterator class ----------------
    private class EntryIterator implements Iterator<Entry<K, V>> {
        private int j = 0;

        public boolean hasNext() {
            return j < table.size();
        }

        public Entry<K, V> next() {
            if (j == table.size())
                throw new NoSuchElementException("No further entries");
            return table.get(j++);
        }

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    } // ----------- end of nested EntryIterator class -----------

}