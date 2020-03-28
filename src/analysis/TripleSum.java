package analysis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Counts the number of triples in an array that sum to 0.
 *
 * @author Rajit Banerjee, 18202817
 * Reference: Algorithms by Sedgewick and Wayne.
 */
public class TripleSum {
    private static final int ARRAY_SIZE = 8;

    /**
     * Returns the number of triples in the array that sum to 0.
     * Complexity: O(n^2 log n)
     *
     * @param arr the array of integers
     * @return the number of triples that sum to exactly 0
     * @throws IllegalArgumentException if array contains duplicates
     */
    public static int count(long[] arr) throws IllegalArgumentException {
        Arrays.sort(arr);
        if (hasDuplicates(arr))
            throw new IllegalArgumentException();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Arrays.binarySearch(arr, -(arr[i] + arr[j])) > j) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Checks if a sorted array contains duplicate numbers.
     *
     * @param arr sorted integer array
     * @return {@code true} if given array contains duplicates
     */
    private static boolean hasDuplicates(long[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == arr[i + 1])
                return true;
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/analysis/triple_sum_ints.txt"));
        long[] arr = new long[ARRAY_SIZE];
        int x = 0;
        while (sc.hasNextLong()) {
            arr[x++] = sc.nextLong();
        }
        System.out.println(Arrays.toString(arr));
        final long startTime = System.nanoTime();
        int count = count(arr);
        final long elapsed = System.nanoTime() - startTime;

        System.out.println("Number of triples summing to 0 =  " + count);
        System.out.println("Time taken for computation = " + elapsed + " nanoseconds");
    }

}