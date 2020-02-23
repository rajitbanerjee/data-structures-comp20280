package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @Test
    void testSingleWord() {
        assertTrue(Palindrome.isPalindrome("Race-car"));
        assertTrue(Palindrome.isPalindrome("Radar"));
        assertTrue(Palindrome.isPalindrome("mAdAm"));
        assertFalse(Palindrome.isPalindrome("Mama"));
        assertFalse(Palindrome.isPalindrome("Assess"));
    }

    @Test
    void testSentence() {
        String[] inputs = {"Step on no pets", "Top spot", "Was it a cat I saw?",
                "eva, can I see bees in a cave?", "no lemon, no melon"};
        for (String each : inputs) {
            assertTrue(Palindrome.isPalindrome(each));
        }
    }

}