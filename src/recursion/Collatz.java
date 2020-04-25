package recursion;

/**
 * Collatz sequence using recursion.
 *
 * @author Rajit Banerjee, 18202817
 */

public class Collatz {
    public static int sequence(int n) {
        if (n == 1) {
            return n;
        } else if (n % 2 == 0) {
            return sequence(n / 2);
        } else {
            return sequence(n * 3 + 1);
        }
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ Collatz ~");
        System.out.println("Collatz(5): " + sequence(5));
        System.out.println("Collatz(100): " + sequence(100));
    }

}