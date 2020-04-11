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

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("Sum of digits(5): " + sum(5));
        System.out.println("Sum of digits(111): " + sum(111));
        System.out.println("Sum of digits(145): " + sum(145));
    }

}