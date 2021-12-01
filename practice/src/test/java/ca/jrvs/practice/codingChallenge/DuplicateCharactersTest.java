package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateCharactersTest {

    DuplicateCharacters dc;

    @Before
    public void setUp() throws Exception {
        dc = new DuplicateCharacters();
    }

    @Test
    public void findDuplicates() {
        String input = "A black cat";
        char [] expected = {'a', 'c'};
        assertEquals(expected[0], dc.findDuplicates(input)[0]);
        assertEquals(expected[1], dc.findDuplicates(input)[1]);

        String input2 = "cbacdcbc";
        char [] expected2 = {'b', 'c'};
        assertEquals(expected2[0], dc.findDuplicates(input2)[0]);
        assertEquals(expected2[1], dc.findDuplicates(input2)[1]);
    }
}