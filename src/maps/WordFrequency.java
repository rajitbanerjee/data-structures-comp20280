package maps;

import projectCode20280.Entry;
import projectCode20280.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Maps the words in a file with the frequency of occurrence.
 * Reports the top 10 most frequent words.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */

public class WordFrequency {
    // Main method to perform basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new ChainHashMap<>();
        Scanner sc = new Scanner(new File("src/maps/sample_text.txt")).useDelimiter("[^a-zA-Z]+");
        // Store words in a ChainHashMap, with key=word, value=frequency
        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        sc.close();

        // Display the top 10 most frequent words
        ArrayList<Entry<String, Integer>> values = new ArrayList<>();
        for (Entry<String, Integer> entry : map.entrySet()) {
            values.add(entry);
        }
        // Descending order sort
        values.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        System.out.println("Top 10 most frequent words:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10s\t\t(count = %d)\n", values.get(i).getKey(), values.get(i).getValue());
        }
    }

}