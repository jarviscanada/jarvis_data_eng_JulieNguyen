package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainsDuplicateTest {

    ContainsDuplicate cd;

    int[] input1 = {1, 2, 3, 1}; boolean expected1 = true;
    int[] input2 = {1, 2, 3, 4}; boolean expected2 = false;
    int[] input3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}; boolean expected3 = true;

    @Before
    public void setUp() throws Exception {
        cd = new ContainsDuplicate();
    }

    @Test
    public void containsDuplicate() {
        assertEquals(expected1, cd.containsDuplicate(input1));
        assertEquals(expected2, cd.containsDuplicate(input2));
        assertEquals(expected3, cd.containsDuplicate(input3));
    }
}