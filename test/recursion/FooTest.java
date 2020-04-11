package recursion;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for recursion/Foo.java
 *
 * @author Rajit Banerjee, 18202817
 */

class FooTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    static void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testFoo() {
        Foo.foo(2468);
        assertEquals("86422468", outContent.toString().trim());
    }

}