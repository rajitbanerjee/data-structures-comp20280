package projectCode20280;

import java.util.NoSuchElementException;

/**
 * Check the validity of brackets in a given expression.
 *
 * @author Rajit Banerjee, 18202817
 * @author Aonghus Lawlor
 */
public class BracketChecker {
    /**
     * Checks if an expression's brackets are valid.
     *
     * @param in expression to be checked for bracket validity
     * @return {@code true} if brackets are valid, {@code false} otherwise
     */
    public static boolean checkBrackets(String in) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (char ch : in.toCharArray()) {
            try {
                // Push opening brackets to Stack
                if (ch == '(' || ch == '{' || ch == '[') {
                    stack.push(ch);
                } else if (ch == ')' || ch == '}' || ch == ']') {
                    // Closing brackets in expression must match with Stack's top element
                    if (!isSameType(stack.pop(), ch)) {
                        return false;
                    }
                }
            } catch (NoSuchElementException e) {
                // Element can't be popped since Stack is empty
                return false;
            }
        }
        //  Stack must be empty after all the characters of the expression have been processed
        return stack.isEmpty();
    }

    /**
     * Checks if two brackets are of the same type e.g. (), {}, []
     *
     * @param ch1 first bracket
     * @param ch2 second bracket
     * @return {@code true} if brackets are of same type, {@code false} otherwise
     */
    private static boolean isSameType(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '{' && ch2 == '}') ||
                (ch1 == '[' && ch2 == ']');
    }

    // test checkBrackets() function with a list of expressions
    public static void main(String[] args) {
        String[] inputs = {"[]]()()", // not correct
                "c[d]", // correct
                "a{b[c]d}e", // correct
                "a{b(c]d}e", // not correct; ] doesn't ← match
                "a[b{c}d]e}", // not correct; nothing ← matches final }
                "a{b(c) ", // not correct; Nothing ← matches opening {
                "][]][][[]][]][][[[", // not correct
                "(((abc))((d)))))", // not correct
        };
        for (String input : inputs) {
            boolean isBalanced = BracketChecker.checkBrackets(input);
            System.out.println("isBalanced " + (isBalanced ? " yes! " : " no! ") + input);
        }
    }

}