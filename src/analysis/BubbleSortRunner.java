package analysis;

/**
 * Compares the performance of iterative vs recursive Bubble Sort.
 * Performs a timing analysis for arrays of various sizes.
 *
 * @author Rajit Banerjee, 18202817
 */

public class BubbleSortRunner {
    private static final int[] array_sizes = {10, 15, 100, 1000, 10000};

    // Run tests for iterative and recursive bubble sort
    public static void main(String[] args) throws Exception {
        System.out.println("~ BubbleSortRunner: Bubble Sort, Recursive Bubble Sort ~");
        String[] sortTypes = {"bubble_sort", "recursive_bubble_sort"};
        TestRunner.run(sortTypes, array_sizes);
    }

}