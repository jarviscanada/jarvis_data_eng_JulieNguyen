package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwapTwoNumbersTest {

    SwapTwoNumbers stn;

    @Before
    public void setUp() throws Exception {
        stn = new SwapTwoNumbers();
    }

    @Test
    public void swapTwoNumbers() {
        int [] input = {2, 3};
        int [] expected = {3, 2};
        int [] swapped = stn.swapTwoNumbers(input);
        assertEquals(expected[0], swapped[0]);
        assertEquals(expected[1], swapped[1]);
    }

    @Test
    public void swapTwoNumbersArithmetic() {
        int [] input = {2, 3};
        int [] expected = {3, 2};
        int [] swapped = stn.swapTwoNumbersArithmetic(input);
        assertEquals(expected[0], swapped[0]);
        assertEquals(expected[1], swapped[1]);
    }
}