package maps;

import interfaces.Entry;
import interfaces.Map;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for WordFrequency.
 * <p>
 * Compare the maps obtained using ChainHashMap and java.util.HashMap.
 * If the key-value pairs match for the two implementations, it means
 * that ChainHashMap has been implemented correctly.
 *
 * @author Rajit Banerjee, 18202817
 */

class WordFrequencyTest {
    @Test
    void testCounter() throws FileNotFoundException {
        // Store words in ChainHashMap
        Map<String, Integer> map = new ChainHashMap<>();
        Scanner sc = new Scanner(new File("src/maps/sample_text.txt")).useDelimiter("[^a-zA-Z]+");
        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        sc.close();
        // Store words in java.util.HashMap
        java.util.Map<String, Integer> map2 = new HashMap<>();
        Scanner sc2 = new Scanner(new File("src/maps/sample_text.txt")).useDelimiter("[^a-zA-Z]+");
        while (sc2.hasNext()) {
            String word = sc2.next().toLowerCase();
            if (map2.containsKey(word)) {
                map2.put(word, map2.get(word) + 1);
            } else {
                map2.put(word, 1);
            }
        }
        sc2.close();
        // Store all the entries in the two maps into ArrayList objects
        ArrayList<Entry<String, Integer>> customMapValues = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            customMapValues.add(entry);
        }
        ArrayList<java.util.Map.Entry<String, Integer>> defaultMapValues = new ArrayList<>(map2.entrySet());
        assertEquals(defaultMapValues.size(), customMapValues.size());
        // Descending order sort by keys (not by values as done in WordFrequency.java)
        customMapValues.sort((e1, e2) -> e2.getKey().compareTo(e1.getKey()));
        defaultMapValues.sort((e1, e2) -> e2.getKey().compareTo(e1.getKey()));
        // Check if all key-value pairs are equal for ChainHashMap and java.util.HashMap
        for (int i = 0; i < customMapValues.size(); i++) {
            assertEquals(defaultMapValues.get(i).getKey(), customMapValues.get(i).getKey());
            assertEquals(defaultMapValues.get(i).getValue(), customMapValues.get(i).getValue());
        }
    }

}