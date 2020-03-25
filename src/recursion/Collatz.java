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

}