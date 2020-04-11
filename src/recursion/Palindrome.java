package recursion;

/**
 * Palindrome string checker using recursion.
 *
 * @author Rajit Banerjee, 18202817
 */
public class Palindrome {
    // Function to clean the input String and call the helper function
    public static boolean isPalindrome(String input) {
        StringBuilder sb = new StringBuilder();
        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(Character.toUpperCase(ch));
            }
        }
        return check(sb.toString());
    }

    // Recursive function to check palindrome string or not
    private static boolean check(String input) {
        if (input.length() <= 1) {
            return true;
        } else {
            return input.charAt(0) == input.charAt(input.length() - 1) &&
                    check(input.substring(1, input.length() - 1));
        }
    }

    // Main method to run basic tests (proper JUnit tests are in 'test' directory)
    public static void main(String[] args) {
        String[] inputs = {"Step on no pets", "Top spot", "Was it a cat I saw?",
                "eva, can I see bees in a cave?", "no lemon, no melon", "Hello", "Science"};
        for (String each : inputs) {
            System.out.println("\n" + each + "\nisPalindrome = " + isPalindrome(each));
        }
    }

}