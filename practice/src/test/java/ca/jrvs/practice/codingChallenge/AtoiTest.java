package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Test;

public class AtoiTest extends TestCase {

    StringToIntegerAtoi atoi;

    public void setUp() throws Exception {
        super.setUp();
        atoi = new StringToIntegerAtoi();
    }

    @Test
    public void testMyAtoi() {
        //according to test cases on LeetCode
        String ex1 = "42";
        String ex2 = "   -42";
        String ex3 = "4193 with words";
        String ex4 = "words and 987";
        String ex5 = "-91283472332";

        //expected
        int res1 = 42;
        int res2 = -42;
        int res3 = 4193;
        int res4 = 0;
        int res5 = -2147483648;

        assertEquals(res1, atoi.myAtoi(ex1));
        assertEquals(res2, atoi.myAtoi(ex2));
        assertEquals(res3, atoi.myAtoi(ex3));
        assertEquals(res4, atoi.myAtoi(ex4));
        assertEquals(res5, atoi.myAtoi(ex5));

    }
}