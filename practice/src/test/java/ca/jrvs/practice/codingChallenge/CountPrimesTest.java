package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {

    CountPrimes countPrimes;

    @Before
    public void setUp() throws Exception {
        countPrimes = new CountPrimes();
    }

    @Test
    public void countPrimes() {
        int input = 10;
        int input2 = 10000;

        assertEquals(4, countPrimes.countPrimes(input));
        assertEquals(1229, countPrimes.countPrimes(input2));
    }
}