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

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        System.out.println("~ Foo ~");
        System.out.println("Foo(2468):");
        foo(2468);
        System.out.println("\n\nFoo(1234):");
        foo(1234);
    }

}