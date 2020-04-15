package maps;

import projectCode20280.Entry;
import projectCode20280.SortedMap;

import java.util.Comparator;

/**
 * An abstract base class to ease the implementation of the SortedMap interface.
 * <p>
 * 1. It provides an instance variable for a general Comparator to be used to
 * construct an AbstractSortedMap.
 * <p>
 * 2. Multiple compare(a, b) methods that can compare either two entries or two
 * keys using the comparator.
 * <p>
 * 3. It provides a boolean checkKey method that verifies that a given key is
 * appropriate for use with the comparator.
 */

public abstract class AbstractSortedMap<K, V> extends AbstractMap<K, V>
        implements SortedMap<K, V> {

    /**
     * The comparator defining the ordering of keys in the map.
     */
    private final Comparator<K> comp;

    /**
     * Initializes the comparator for the map.
     *
     * @param c comparator defining the order of keys in the map
     */
    protected AbstractSortedMap(Comparator<K> c) {
        comp = c;
    }

    /**
     * Initializes the map with a default comparator (natural ordering).
     */
    @SuppressWarnings("unchecked")
    protected AbstractSortedMap() {
        this((k1, k2) -> ((Comparable<K>) k1).compareTo(k2));
    }

    /**
     * Method for comparing two entries according to key
     */
    protected int compare(Entry<K, V> a, Entry<K, V> b) {
        return comp.compare(a.getKey(), b.getKey());
    }

    /**
     * Method for comparing a key and an entry's key
     */
    protected int compare(K a, Entry<K, V> b) {
        return comp.compare(a, b.getKey());
    }

    /**
     * Method for comparing a key and an entry's key
     */
    protected int compare(Entry<K, V> a, K b) {
        return comp.compare(a.getKey(), b);
    }

    /**
     * Method for comparing two keys
     */
    protected int compare(K a, K b) {
        return comp.compare(a, b);
    }

    /**
     * Determines whether a key is valid.
     */
    protected boolean checkKey(K key) throws IllegalArgumentException {
        try {
            return (comp.compare(key, key) == 0); // see if key can be compared to itself
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("Incompatible key");
        }
    }

}