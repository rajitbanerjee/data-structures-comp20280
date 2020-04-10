package maps;

import projectCode20280.Entry;
import projectCode20280.Map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordFrequency {
    // Store words in a ChainHashMap, with values = word frequency
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, Integer> map = new ChainHashMap<>();
        Scanner sc = new Scanner(new File("src/maps/sample_text.txt"));
        while (sc.hasNext()) {
            String word = clean(sc.next());
            if (map.get(word) == null) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }

        // Display the top 10 most frequent words
        ArrayList<Entry<String, Integer>> values = new ArrayList<>();
        for (Entry<String, Integer> freq : map.entrySet()) {
            values.add(freq);
        }
        values.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        System.out.println("Top 10 most frequent words:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%10s\t\t(count = %d)\n", values.get(i).getKey(), values.get(i).getValue());
        }

    }

    // Remove any punctuation marks attached to a word
    private static String clean(String word) {
        int n = word.length();
        char last = word.charAt(n - 1);
        if (!Character.isLetter(last)) {
            word = word.substring(0, n - 1);
        }
        return word.toLowerCase();
    }

}