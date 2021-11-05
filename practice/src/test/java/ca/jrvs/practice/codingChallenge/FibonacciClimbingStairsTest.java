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
        int expected = 514229;
        int n = 29;
        assertEquals(expected, fcs.fib(n));
        assertEquals(expected, fcs.fibDP(n));
    }


    @Test
    public void testClimbStairs(){
        int expected = 701408733;
        int n = 43;
        assertEquals(expected, fcs.climbStairs(n));
        assertEquals(expected, fcs.climbStairsRec(n));
    }

}