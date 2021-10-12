package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class RotateStringTest extends TestCase {

    RotateString rotateString;

    public void setUp() throws Exception {
        super.setUp();
        rotateString = new RotateString();
    }

    public void testRotateString() {

        assertEquals(true, rotateString.rotateString("abcde", "cdeab"));
        assertEquals(false, rotateString.rotateString("abcde", "abced"));

    }
}