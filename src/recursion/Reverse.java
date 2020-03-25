package recursion;

/**
 * Reverse an array using recursion.
 *
 * @author Rajit Banerjee, 18202817
 */
public class Reverse {
    public static void reverseArray(Object[] A, int i, int j) {
        if (i < j) {
            swap(A, i, j);
            reverseArray(A, i + 1, j - 1);
        }
    }

    private static void swap(Object[] A, int i, int j) {
        Object temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}