package recursion;

public class Digits {
    // recursive sum of digits
    public static int sum(int number) {
        if (number == 0) {
            return 0;
        } else {
            return (number % 10) + sum(number / 10);
        }
    }
}
