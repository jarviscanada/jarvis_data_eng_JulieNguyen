package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.*;

public class FibonacciClimbingStairsTest extends TestCase {

    FibonacciClimbingStairs fcs;

    @Before
    public void setUp() throws Exception {
        fcs = new FibonacciClimbingStairs();
        super.setUp();
    }

    @Test
    public void testFib(){
        int expected = 433494437;
        int n = 43;
        assertEquals(expected, fcs.fib(n));
    }

    @Test
    public void testClimbStairs(){
        int expected = 701408733;
        int n = 43;
        assertEquals(expected, fcs.climbStairs(n));
    }

}