package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveElementTest {

    RemoveElement re;
    int[] input1 = {3, 2, 2, 3}; int val1 = 3; int expected1 = 2;
    int[] input2 = {0,1,2,2,3,0,4,2}; int val2 = 2; int expected2 = 5;

    @Before
    public void setUp() throws Exception {
        re = new RemoveElement();
    }

    @Test
    public void removeElement() {
        assertEquals(expected1, re.removeElement(input1, val1));
        assertEquals(expected2, re.removeElement(input2, val2));
    }
}