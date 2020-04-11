package stacks;

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
    public static boolean isValid(String in) {
        LinkedStack<Character> stack = new LinkedStack<>();
        for (char ch : in.toCharArray()) {
            // Push opening brackets to Stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                // Closing brackets in expression must match with Stack's top element
                if (stack.isEmpty() || !isSameType(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        //  Stack must be empty after all the characters of the expression have been processed
        return stack.isEmpty();
    }

    // Checks if two brackets are of the same type e.g. (), {}, []
    private static boolean isSameType(char ch1, char ch2) {
        return (ch1 == '(' && ch2 == ')') ||
                (ch1 == '{' && ch2 == '}') ||
                (ch1 == '[' && ch2 == ']');
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
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
            boolean isBalanced = BracketChecker.isValid(input);
            System.out.println("isBalanced " + (isBalanced ? "\tyes!\t" : "\tno!\t\t") + input);
        }
    }

}