package maps;

import projectCode20280.Entry;
import projectCode20280.Map;

import java.util.ArrayList;

/*
 * Map implementation using hash table with separate chaining.
 */

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    // a fixed capacity array of UnsortedTableMap that serve as buckets
    private UnsortedTableMap<K, V>[] table; // initialised within createTable

    /**
     * Creates a hash table with capacity 17 and prime factor 109345121.
     */
    public ChainHashMap() {
        super();
    }

    /**
     * Creates an empty table having length equal to current capacity.
     */
    @Override
    @SuppressWarnings({"unchecked"})
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    /**
     * Returns value associated with key k in bucket with hash value h. If no such
     * entry exists, returns null.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return associate value (or null, if no such entry)
     */
    @Override
    protected V bucketGet(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        return (bucket == null) ? null : bucket.get(k);
    }

    /**
     * Associates key k with value v in bucket with hash value h, returning the
     * previously associated value, if any.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @param v the value to be associated
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketPut(int h, K k, V v) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            table[h] = new UnsortedTableMap<>();
            bucket = table[h];
        }
        int previousSize = bucket.size();
        V previousValue = bucket.put(k, v);
        n += (bucket.size() - previousSize);
        return previousValue;
    }

    /**
     * Removes entry having key k from bucket with hash value h, returning the
     * previously associated value, if found.
     *
     * @param h the hash value of the relevant bucket
     * @param k the key of interest
     * @return previous value associated with k (or null, if no such entry)
     */
    @Override
    protected V bucketRemove(int h, K k) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) {
            return null;
        } else {
            int previousSize = bucket.size();
            V previousValue = bucket.remove(k);
            n -= (previousSize - bucket.size());
            return previousValue;
        }
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     *
     * @return iterable collection of the map's entries
     */
    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> temp = new ArrayList<>();
        for (UnsortedTableMap<K, V> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket.entrySet()) {
                    temp.add(entry);
                }
            }
        }
        return temp;
    }

    // Main method to perform basic tests
    public static void main(String[] args) {
        Map<Integer, String> m = new ChainHashMap<>();
        m.put(1, "One");
        m.put(10, "Ten");
        m.put(11, "Eleven");
        m.put(20, "Twenty");

        System.out.println("m: " + m);

        m.remove(11);
        System.out.println("m: " + m);
    }

    /**
     * Gets the String for the hash map.
     *
     * @return String for the hash map
     */
    @Override
    public String toString() {
        return entrySet().toString();
    }

}