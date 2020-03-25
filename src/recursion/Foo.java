package recursion;

/**
 * Demonstrate recursion call stack concept.
 *
 * @author Rajit Banerjee, 18202817
 */
public class Foo {
    public static void foo(int x) {
        System.out.print(x % 10);
        if (x / 10 != 0) {
            foo(x / 10);
        }
        System.out.print(x % 10);
    }

}