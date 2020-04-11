package stacks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
                "[]]()()", // Not correct
                "a{b(c]d}e", // Not correct; ] doesn't ← match
                "a[b{c}d]e}", // Not correct; nothing ← matches final }
                "a{b(c) ", // Not correct; Nothing ← matches opening {
                "][]][][[]][]][][[[", // Not correct
                "(((abc))((d)))))", // Not correct}
        };
        for (String expression : inputs) {
            assertFalse(BracketChecker.isValid(expression));
        }
    }

}