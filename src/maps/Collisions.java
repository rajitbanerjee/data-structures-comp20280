package maps;

import projectCode20280.Entry;
import projectCode20280.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Computes the number of collisions using different hash functions, before
 * applying the compression algorithm.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class Collisions {
    // Main method to run basic tests
    public static void main(String[] args) throws FileNotFoundException {
        // Compute the number of collisions using different hash functions (without compression)
        System.out.println("Collisions using polynomial accumulation (a = 41): " +
                collisions("polynomial", 41));
        System.out.println("Collisions using polynomial accumulation (a = 17): " +
                collisions("polynomial", 17));
        System.out.println("Collisions using cyclic shift hashing (shift = 7): " +
                collisions("cyclic", 7));
        System.out.println("Collisions using old Java hash code function: " +
                collisions("old_java", 0));
        System.out.println("Collisions using default hash code function: " +
                collisions("", 0));
    }

    // Count and return the number of collisions for a given hash function (before compression)
    private static int collisions(String hashType, int value) throws FileNotFoundException {
        // Maps hash codes with the words having that hash code (all before compression)
        Map<Integer, List<String>> map = new ChainHashMap<>();
        Scanner sc = new Scanner(new File("src/maps/words.txt"));
        while (sc.hasNext()) {
            String word = sc.next();
            int hash;
            switch (hashType) {
                case "polynomial":
                    // Use Horner's method to perform polynomial accumulation hashing
                    hash = polyHash(word, value);
                    break;
                case "cyclic":
                    // Use cyclic hashing with given shift value
                    hash = cyclicHash(word, value);
                    break;
                case "old_java":
                    hash = hashCode(word);
                    break;
                default:
                    hash = word.hashCode();
            }
            List<String> list;
            if (map.get(hash) == null) {
                list = new ArrayList<>();
            } else {
                list = map.get(hash);
            }
            list.add(word);
            map.put(hash, list);
        }
        sc.close();

        int ans = 0;
        for (Entry<Integer, List<String>> entry : map.entrySet()) {
            ans += entry.getValue().size();
        }
        return ans - map.size();
    }

    // Horner's method for polynomial hashing
    private static int polyHash(String key, int a) {
        int hash = 0;
        for (char x : key.toCharArray()) {
            hash = hash * a + x;
        }
        return hash;
    }

    // Cyclic shift hashing
    private static int cyclicHash(String key, int shift) {
        int hash = 0;
        for (char x : key.toCharArray()) {
            hash = (hash << shift) | (hash >>> (32 - shift));
            hash += x;
        }
        return hash;
    }

    // Old Java hash code function
    private static int hashCode(String key) {
        int hash = 0;
        int skip = Math.max(1, key.length() / 8);
        for (int i = 0; i < key.length(); i += skip) {
            hash = (hash * 37) + key.charAt(i);
        }
        return hash;
    }

}