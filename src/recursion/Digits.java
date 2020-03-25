package recursion;

/**
 * Recursively add the digits of a number.
 *
 * @author Rajit Banerjee, 18202817
 */
public class Digits {
    public static int sum(int number) {
        if (number == 0) {
            return 0;
        } else {
            return (number % 10) + sum(number / 10);
        }
    }

}