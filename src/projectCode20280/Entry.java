package projectCode20280;

/**
 * Interface for a key-value pair.
 *
 * @param <K> generic type of entry key
 * @param <V> generic type of entry value
 * @author Aonghus Lawlor
 */

public interface Entry<K, V> {
    /**
     * Returns the key stored in this entry.
     *
     * @return the entry's key
     */
    K getKey();

    /**
     * Returns the value stored in this entry.
     *
     * @return the entry's value
     */
    V getValue();

}