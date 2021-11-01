package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateNumberTest {

    DuplicateNumber dn;

    int[] input1 = {1,3,4,2,2}; int expected1 = 2;
    int[] input2 = {3,1,3,4,2}; int expected2 = 3;
    int[] input3 = {1,1}; int expected3 = 1;
    int[] input4 = {1,1,2}; int expected4 = 1;

    @Before
    public void setUp() throws Exception {
        dn = new DuplicateNumber();
    }

    @Test
    public void findDuplicate() {
        assertEquals(expected1, dn.findDuplicate(input1));
        assertEquals(expected2, dn.findDuplicate(input2));
        assertEquals(expected3, dn.findDuplicate(input3));
        assertEquals(expected4, dn.findDuplicate(input4));
    }

    @Test
    public void findDuplicatesUsingSorting() {
        assertEquals(expected1, dn.findDuplicatesUsingSorting(input1));
        assertEquals(expected2, dn.findDuplicatesUsingSorting(input2));
        assertEquals(expected3, dn.findDuplicatesUsingSorting(input3));
        assertEquals(expected4, dn.findDuplicatesUsingSorting(input4));
    }
}