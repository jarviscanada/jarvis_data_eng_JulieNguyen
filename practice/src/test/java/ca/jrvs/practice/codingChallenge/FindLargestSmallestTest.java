package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FindLargestSmallestTest {

    FindLargestSmallest fls;

    int[]test1 = {1, 2, 3, 4};
    int[]test2 = {50, 2, 104, 4};
    int[]test3 = {1};

    @Before
    public void setUp() throws Exception {
        fls = new FindLargestSmallest();
    }

    @Test
    public void findLargest() {
        assertEquals(4 , fls.findLargest(test1));
        assertEquals(104 , fls.findLargest(test2));
        assertEquals(1 , fls.findLargest(test3));
    }

    @Test
    public void findSmallest() {
        assertEquals(1 , fls.findSmallest(test1));
        assertEquals(2 , fls.findSmallest(test2));
        assertEquals(1 , fls.findSmallest(test3));
    }

    @Test
    public void findLargestUsingStream() {
        assertEquals(4 , fls.findLargestUsingStream(test1));
        assertEquals(104 , fls.findLargestUsingStream(test2));
        assertEquals(1 , fls.findLargestUsingStream(test3));
    }

    @Test
    public void findSmallestUsingStream() {
        assertEquals(1 , fls.findSmallestUsingStream(test1));
        assertEquals(2 , fls.findSmallestUsingStream(test2));
        assertEquals(1 , fls.findSmallestUsingStream(test3));
    }

    @Test
    public void findLargestUsingAPI() {
        assertEquals(4 , fls.findLargestUsingAPI(test1));
        assertEquals(104 , fls.findLargestUsingAPI(test2));
        assertEquals(1 , fls.findLargestUsingAPI(test3));
    }

    @Test
    public void findSmallestUsingAPI() {
        assertEquals(1 , fls.findSmallestUsingAPI(test1));
        assertEquals(2 , fls.findSmallestUsingAPI(test2));
        assertEquals(1 , fls.findSmallestUsingAPI(test3));
    }
}