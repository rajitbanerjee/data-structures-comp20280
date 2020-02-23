package recursion;

public class Fibonacci {
    private static int[] memo = new int[100];

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
        }
        if (n <= 2) {
            memo[n] = n - 1;
        } else if (memo[n] == 0) {
            memo[n] = number(n - 1) + number(n - 2);
        }
        return memo[n];
    }
}
