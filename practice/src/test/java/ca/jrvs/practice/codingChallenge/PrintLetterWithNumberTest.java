package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class PrintLetterWithNumberTest extends TestCase {

    PrintLetterWithNumber plwn;

    public void setUp() throws Exception {
        super.setUp();

        plwn = new PrintLetterWithNumber();
    }

    public void testPrintLetterWithNumber(){
        assertEquals("a1b2c3e5e5", plwn.printLetterWithNumber("abcee"));
    }

}