package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class ValidAnagramTest extends TestCase {

    ValidAnagram va;

    public void setUp() throws Exception {
        super.setUp();
        va = new ValidAnagram();
    }

    public void testIsAnagram() {

        assertEquals(true, va.isAnagram("anagram", "nagaram"));
        assertEquals(false, va.isAnagram("rat", "car"));

    }

    public void testIsAnagramON() {

        assertEquals(true, va.isAnagramON("anagram", "nagaram"));
        assertEquals(false, va.isAnagramON("rat", "car"));

    }
}