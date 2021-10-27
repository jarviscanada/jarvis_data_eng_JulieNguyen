package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumberTest {

    MissingNumber mn;

    @Before
    public void setUp() throws Exception {
        mn = new MissingNumber();
    }

    @Test
    public void testCase1() {
        //missing number is in the middle
        int [] input = {9,6,4,2,3,5,7,0,1};

        assertEquals(8, mn.missingNumber(input));
        assertEquals(8, mn.missingNumberUsingSet(input));
        assertEquals(8, mn.missingNumberUsingGauss(input));
    }

    @Test
    public void testCase2() {
        //missing number is the max+1 number
        int [] input = {0,1};
        assertEquals(2, mn.missingNumber(input));
        assertEquals(2, mn.missingNumberUsingSet(input));
        assertEquals(2, mn.missingNumberUsingGauss(input));
    }

    @Test
    public void testCase3() {
        //missing number is 0
        int [] input = {1};
        assertEquals(0, mn.missingNumber(input));
        assertEquals(0, mn.missingNumberUsingSet(input));
        assertEquals(0, mn.missingNumberUsingGauss(input));
    }
}