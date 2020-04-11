package analysis;

/**
 * Tests some basic sorting algorithms in the Sort class.
 * Performs a timing analysis for arrays of various sizes.
 *
 * @author Rajit Banerjee, 18202817
 */

public class BasicSortRunner {
    private static final int[] array_sizes = {10, 15, 100, 1000, 10000};

    // Run tests for bubble sort, selection sort, and insertion sort
    public static void main(String[] args) throws Exception {
        String[] sortTypes = {"bubble_sort", "selection_sort", "insertion_sort"};
        TestRunner.run(sortTypes, array_sizes);
    }

}