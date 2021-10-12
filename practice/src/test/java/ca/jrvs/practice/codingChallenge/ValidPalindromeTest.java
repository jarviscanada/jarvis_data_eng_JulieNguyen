package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Test;

public class ValidPalindromeTest extends TestCase {

    ValidPalindrome palindrome;

    public void setUp() throws Exception {
        super.setUp();
        palindrome = new ValidPalindrome();
    }

    @Test
    public void testIsPalindrome() {
        assertEquals(true, palindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertEquals(false, palindrome.isPalindrome("race a car"));
    }
}