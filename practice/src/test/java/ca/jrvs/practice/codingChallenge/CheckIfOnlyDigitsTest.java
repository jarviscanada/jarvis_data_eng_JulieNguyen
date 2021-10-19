package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Before;

public class CheckIfOnlyDigitsTest extends TestCase {

    CheckIfOnlyDigits ciod;
    String test1;
    String test2;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        ciod = new CheckIfOnlyDigits();
        test1 = "4362784326";
        test2 = "43798A43728947AA";
    }

    public void testCheckStringUsingRegex() {
        assertEquals(true, ciod.checkStringUsingRegex(test1));
        assertEquals(false, ciod.checkStringUsingRegex(test2));
    }

    public void testCheckStringUsingAPI() {
        assertEquals(true, ciod.checkStringUsingAPI(test1));
        assertEquals(false, ciod.checkStringUsingAPI(test2));
    }
}