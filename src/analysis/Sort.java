package analysis;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * Callable class to implement different types of sorts on an array
 * containing Comparable elements.
 *
 * @param <E> generic type of items to be sorted
 * @author Rajit Banerjee, 18202817
 */

public class Sort<E extends Comparable<E>> implements Callable<E[]> {
    private final Method sort;
    private final E[] arr;

    /**
     * Initialise new sort, use reflection to get the declared method
     * for the required sort type.
     *
     * @param sortType name of sort method to be called
     * @param arr      array to be sorted
     * @throws NoSuchMethodException if method with required name doesn't exist
     */
    public Sort(String sortType, E[] arr) throws NoSuchMethodException {
        sort = Sort.class.getMethod(sortType, Comparable[].class);
        this.arr = arr;
    }

    /**
     * Apply BubbleSort to the given array.
     *
     * @param arr array to be sorted
     * @param <E> generic type of array items
     */
    public static <E extends Comparable<E>> void bubble_sort(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    swap(arr, j + 1, j);
                }
            }
        }
    }

    /**
     * Apply Recursive BubbleSort to the given array.
     *
     * @param arr array to be sorted
     * @param <E> generic type of array items
     */
    public static <E extends Comparable<E>> void recursive_bubble_sort(E[] arr) {
        recursiveBubble(arr, arr.length);
    }

    // Recursive bubble sort algorithm
    private static <E extends Comparable<E>> void recursiveBubble(E[] arr, int size) {
        if (size == 1)
            return;
        for (int j = 0; j < size - 1; j++)
            if (arr[j].compareTo(arr[j + 1]) > 0) {
                swap(arr, j, j + 1);
            }
        recursiveBubble(arr, size - 1);
    }

    /**
     * Apply SelectionSort on the given array.
     *
     * @param arr array to be sorted
     * @param <E> generic type of array items
     */
    public static <E extends Comparable<E>> void selection_sort(E[] arr) {
        int min_index;
        for (int i = 0; i < arr.length - 1; i++) {
            min_index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min_index]) < 0) {
                    min_index = j;
                }
            }
            swap(arr, i, min_index);
        }
    }

    /**
     * Apply InsertionSort on the given array.
     *
     * @param arr array to be sorted
     * @param <E> generic type of array items
     */
    public static <E extends Comparable<E>> void insertion_sort(E[] arr) {
        insertion_sort(arr, 0, arr.length - 1);
    }

    // Insertion sort algorithm
    private static <E extends Comparable<E>> void insertion_sort(E[] arr, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            E key = arr[i];
            int j = i - 1;
            /*
             Shift elements to the right as long as
             they are greater than key element
             */
            while (j >= lo && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j--];
            }
            arr[j + 1] = key;
        }
    }

    // Swap elements at indices i and j or given array
    private static <E extends Comparable<E>> void swap(E[] a, int i, int j) {
        E temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Check if given array is not sorted yet.
     *
     * @param a   array to be checked
     * @param <E> generic type of array items
     * @return {@code true} if array is not sorted
     */
    public static <E extends Comparable<E>> boolean isNotSorted(E[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == null || a[i].compareTo(a[i + 1]) > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Display a given array on the command line.
     *
     * @param arr array to be displayed
     * @param <E> generic type of array items
     */
    public static <E extends Comparable<E>> String display(E[] arr) {
        return Arrays.toString(arr);
    }

    /**
     * Invokes a particular type of sort in the class.
     *
     * @return the sorted array
     * @throws InvocationTargetException if method to be invoked throws underlying exception
     * @throws IllegalAccessException    if method to be invoked is not defined
     */
    @Override
    public E[] call() throws InvocationTargetException, IllegalAccessException {
        sort.invoke(null, (Object) arr);
        return arr;
    }

}