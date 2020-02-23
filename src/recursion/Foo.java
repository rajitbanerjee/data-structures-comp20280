package recursion;

public class Foo {
    public static void foo(int x) {
        System.out.print(x % 10);
        if (x / 10 != 0) {
            foo(x / 10);
        }
        System.out.print(x % 10);
    }

    public static void main(String[] args) {
        foo(2468);
    }
}
