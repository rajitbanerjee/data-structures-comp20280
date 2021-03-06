package recursion;

import java.util.Arrays;

/**
 * Reverse an array using recursion.
 *
 * @author Rajit Banerjee, 18202817
 */

public class Reverse {
    // Call recursive method to reverse array
    public static void reverseArray(Object[] A) {
        reverseArray(A, 0, A.length - 1);
    }

    // Reverse array using recursion
    private static void reverseArray(Object[] A, int i, int j) {
        if (i < j) {
            swap(A, i, j);
            reverseArray(A, i + 1, j - 1);
        }
    }

    // Swap items at index i and j or given array
    private static void swap(Object[] A, int i, int j) {
        Object temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    // Main method to run basic tests (proper JUnit tests are in /test directory
    public static void main(String[] args) {
        System.out.println("~ Reverse ~");
        Integer[] A = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(A));
        Reverse.reverseArray(A);
        System.out.println("Reversed array: " + Arrays.toString(A));
    }

}