package analysis;

/**
 * Implements sorting algorithms on integer arrays.
 *
 * @author Rajit Banerjee, 18202817
 */
public class Sort {
    // bubble sort algorithm
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    // selection sort algorithm
    public static void selection(int[] arr) {
        int min_index;
        for (int i = 0; i < arr.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }
    }

    // insertion sort algorithm
    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            /*
             * shift elements [0 to i-1] to the right as long as they are greater than key
             * element
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }
    }

    // method to swap elements at indices i and j or given array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}