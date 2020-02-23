package projectCode20280;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for BracketChecker.
 *
 * @author Rajit Banerjee, 18202817
 */
class BracketCheckerTest {
    @Test
    void testValidBrackets() {
        String[] inputs = {
                "[]()()",
                "a{b(c)d}e",
                "{a[b{c}d]e}",
                "a{b(c)} ",
                "[][][[]][][]",
                "(((abc))((d)))",
        };
        for (String expression : inputs) {
            assertTrue(BracketChecker.isValid(expression));
        }
    }

    @Test
    void testInvalidBrackets() {
        String[] inputs = {
                "[]]()()", // not correct
                "a{b(c]d}e", // not correct; ] doesn't ← match
                "a[b{c}d]e}", // not correct; nothing ← matches final }
                "a{b(c) ", // not correct; Nothing ← matches opening {
                "][]][][[]][]][][[[", // not correct
                "(((abc))((d)))))", // not correct}
        };
        for (String expression : inputs) {
            assertFalse(BracketChecker.isValid(expression));
        }
    }

}