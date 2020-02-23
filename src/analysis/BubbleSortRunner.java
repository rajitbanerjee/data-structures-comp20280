package analysis;

import java.util.Scanner;

/**
 * Compares the performance of iterative vs recursive Bubble Sort.
 * Performs a timing analysis for arrays of various sizes.
 *
 * @author Rajit Banerjee, 18202817
 */
public class BubbleSortRunner {
    static Scanner sc = new Scanner(System.in);
    private static final int[] SIZE = {10, 100, 10000, 10000};
    private static int[] a = generateArray(SIZE[0]);
    private static int[] b = generateArray(SIZE[1]);
    private static int[] c = generateArray(SIZE[2]);
    private static int[] d = generateArray(SIZE[3]);

    // run tests for all 3 sorting algorithms with arrays of various sizes
    public static void main(String[] args) {
        System.out.println("1. Run timing analysis.");
        System.out.println("2. See sorted arrays (only small sizes).");
        System.out.print("Choose 1 or 2: ");
        int op = sc.nextInt();
        switch (op) {
            case 1:
                runBubbleTests();
                runRecursiveBubbleTests();
                break;
            case 2:
                seeBubbleSort();
                seeRecursiveBubbleSort();
                break;
            default:
                System.out.println("Invalid choice.");
        }

    }

    // bubble sort timing analysis
    private static void runBubbleTests() {
        int[] a1 = new int[SIZE[0]];
        int[] b1 = new int[SIZE[1]];
        int[] c1 = new int[SIZE[2]];
        int[] d1 = new int[SIZE[3]];
        System.arraycopy(a, 0, a1, 0, a.length);
        System.arraycopy(b, 0, b1, 0, b.length);
        System.arraycopy(c, 0, c1, 0, c.length);
        System.arraycopy(d, 0, d1, 0, d.length);

        printLine();
        System.out.println("\n-Bubble Sort-");
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n", a1.length, testBubble(a1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n", b1.length, testBubble(b1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n", c1.length, testBubble(c1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n", d1.length, testBubble(d1));
    }

    // insertion sort timing analysis
    private static void runRecursiveBubbleTests() {
        int[] a1 = new int[SIZE[0]];
        int[] b1 = new int[SIZE[1]];
        int[] c1 = new int[SIZE[2]];
        int[] d1 = new int[SIZE[3]];
        System.arraycopy(a, 0, a1, 0, a.length);
        System.arraycopy(b, 0, b1, 0, b.length);
        System.arraycopy(c, 0, c1, 0, c.length);
        System.arraycopy(d, 0, d1, 0, d.length);

        printLine();
        System.out.println("\n-Recursive Bubble Sort-");
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n",
                a1.length, testRecursiveBubble(a1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n",
                b1.length, testRecursiveBubble(b1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n",
                c1.length, testRecursiveBubble(c1));
        System.out.printf("Time taken for array of size %d =\t%d nanosec\n",
                d1.length, testRecursiveBubble(d1));
    }

    // test Bubble Sort performance for randomly generated array
    private static long testBubble(int[] a) {
        long startTime = System.nanoTime();
        Sort.bubble(a);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // test RecursiveBubble Sort performance for randomly generated array
    private static long testRecursiveBubble(int[] a) {
        long startTime = System.nanoTime();
        Sort.recursiveBubble(a, a.length);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    // bubble sort before and after
    private static void seeBubbleSort() {
        int[] a1 = new int[SIZE[0]];
        int[] b1 = new int[SIZE[1]];
        System.arraycopy(a, 0, a1, 0, a.length);
        System.arraycopy(b, 0, b1, 0, b.length);

        System.out.printf("\nOriginal array (size %d):\t", SIZE[0]);
        display(a1);
        System.out.print("After bubble sort:\t\t");
        Sort.bubble(a1);
        display(a1);

        System.out.printf("\nOriginal array (size %d):\t", SIZE[1]);
        display(b1);
        System.out.print("After bubble sort:\t\t");
        Sort.bubble(b1);
        display(b1);
    }

    // insertion sort before and after
    private static void seeRecursiveBubbleSort() {
        int[] a1 = new int[SIZE[0]];
        int[] b1 = new int[SIZE[1]];
        System.arraycopy(a, 0, a1, 0, a.length);
        System.arraycopy(b, 0, b1, 0, b.length);

        System.out.printf("\nOriginal array (size %d):\t", SIZE[0]);
        display(a1);
        System.out.print("After recursive bubble sort:\t\t");
        Sort.recursiveBubble(a1, a1.length);
        display(a1);

        System.out.printf("\nOriginal array (size %d):\t", SIZE[1]);
        display(b1);
        System.out.print("After recursive bubble sort:\t\t");
        Sort.recursiveBubble(b1, b1.length);
        display(b1);
    }

    // generate a randomly filled array of given size
    private static int[] generateArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            // fill array with random elements between [0, size)
            arr[i] = (int) (Math.random() * size);
        }
        return arr;
    }

    // display the array elements
    private static void display(int[] arr) {
        StringBuilder ans = new StringBuilder("{ ");
        for (int i = 0; i < arr.length - 1; i++) {
            ans.append(arr[i]).append(", ");
        }
        ans.append(arr[arr.length - 1]).append(" }");
        System.out.println(ans);
    }

    // print a line of 80 dashes
    private static void printLine() {
        System.out.println();
        for (int i = 0; i < 80; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}