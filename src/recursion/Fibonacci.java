package recursion;

/**
 * Fibonacci sequence using recursion.
 *
 * @author Rajit Banerjee, 18202817
 */

public class Fibonacci {
    private static final int[] memo = new int[100];

    /**
     * Fast nth Fibonacci using memoisation.
     *
     * @param n need to find this nth Fibonacci number
     * @return the nth number in the Fibonacci sequence
     * @throws IllegalArgumentException if input is <= 0
     */
    public static int number(int n) throws IllegalArgumentException {
        if (n <= 0) {
            throw new IllegalArgumentException();
        } else if (n <= 2) {
            memo[n] = n - 1;
        } else if (memo[n] == 0) {
            memo[n] = number(n - 1) + number(n - 2);
        }
        return memo[n];
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ Fibonacci ~");
        System.out.println("Fibonacci(1): " + number(1));
        System.out.println("Fibonacci(2): " + number(2));
        System.out.println("Fibonacci(3): " + number(3));
        System.out.println("Fibonacci(4): " + number(4));
        System.out.println("Fibonacci(5): " + number(5));
        System.out.println("Fibonacci(6): " + number(6));
        System.out.println("Fibonacci(7): " + number(7));
        System.out.println("Fibonacci(8): " + number(8));
        System.out.println("Fibonacci(9): " + number(9));
        System.out.println("Fibonacci(10): " + number(10));
    }

}