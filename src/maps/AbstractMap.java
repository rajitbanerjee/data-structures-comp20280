package maps;

import projectCode20280.Entry;
import projectCode20280.Map;

import java.util.Iterator;

/**
 * An abstract base class to ease the implementation of the Map interface.
 * <p>
 * The base class provides three means of support:
 * 1) It provides an isEmpty implementation based upon the abstract size() method.
 * 2) It defines a protected MapEntry class as a concrete implementation of the entry interface
 * 3) It provides implementations of the keySet and values methods, based on
 * use of a presumed implementation of the entrySet method.
 */
public abstract class AbstractMap<K, V> implements Map<K, V> {

    /**
     * Tests whether the map is empty.
     *
     * @return true if the map is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    // Provides support for keySet() and values() methods, based on
    // the entrySet() method that must be provided by subclasses

    /**
     * Returns an iterable collection of the keys contained in the map.
     *
     * @return iterable collection of the map's keys
     */
    @Override
    public Iterable<K> keySet() {
        return new KeyIterable();
    }

    /**
     * Returns an iterable collection of the values contained in the map. Note that
     * the same value will be given multiple times in the result if it is associated
     * with multiple keys.
     *
     * @return iterable collection of the map's values
     */
    @Override
    public Iterable<V> values() {
        return new ValueIterable();
    }

    // ---------------- nested MapEntry class ----------------

    /**
     * A concrete implementation of the Entry interface to be used within a Map
     * implementation.
     */
    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K k; // key
        private V v; // value

        public MapEntry(K key, V value) {
            k = key;
            v = value;
        }

        // public methods of the Entry interface
        public K getKey() {
            return k;
        }

        // utilities not exposed as part of the Entry interface
        protected void setKey(K key) {
            k = key;
        }

        public V getValue() {
            return v;
        }

        protected V setValue(V value) {
            V old = v;
            v = value;
            return old;
        }

        /**
         * Returns string representation (for debugging only)
         */
        @Override
        public String toString() {
            return "<" + k + ", " + v + ">";
        }

    } // ----------- end of nested MapEntry class -----------

    // ---------------- nested KeyIterable class ----------------
    private class KeyIterable implements Iterable<K> {
        KeyIterator itr = new KeyIterator();

        public Iterator<K> iterator() {
            return itr;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            while (itr.hasNext()) {
                sb.append(itr.next()).append(", ");
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
            sb.append("]");
            return sb.toString();
        }
    } // ----------- end of nested KeyIterable class -----------

    // ---------------- nested KeyIterator class ----------------
    private class KeyIterator implements Iterator<K> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public K next() {
            return entries.next().getKey();
        } // return key!

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    } // ----------- end of nested KeyIterator class -----------

    // ---------------- nested ValueIterable class ----------------
    private class ValueIterable implements Iterable<V> {
        ValueIterator itr = new ValueIterator();

        public Iterator<V> iterator() {
            return itr;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            while (itr.hasNext()) {
                sb.append(itr.next()).append(", ");
            }
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
            sb.append("]");
            return sb.toString();
        }
    } // ----------- end of nested ValueIterable class -----------

    // ---------------- nested ValueIterator class ----------------
    private class ValueIterator implements Iterator<V> {
        private Iterator<Entry<K, V>> entries = entrySet().iterator(); // reuse entrySet

        public boolean hasNext() {
            return entries.hasNext();
        }

        public V next() {
            return entries.next().getValue();
        } // return value!

        public void remove() {
            throw new UnsupportedOperationException("remove not supported");
        }
    } // ----------- end of nested ValueIterator class -----------

}