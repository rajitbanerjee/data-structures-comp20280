package recursion;

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
        }
        return input.charAt(0) == input.charAt(input.length() - 1) &&
                check(input.substring(1, input.length() - 1));
    }
}
