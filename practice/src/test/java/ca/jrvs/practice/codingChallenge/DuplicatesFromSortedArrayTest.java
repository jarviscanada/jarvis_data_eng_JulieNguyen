package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

public class DuplicatesFromSortedArrayTest {

    DuplicatesFromSortedArray dfsa;

    @Before
    public void setUp(){
        dfsa = new DuplicatesFromSortedArray();
    }

    @Test
    public void removeDuplicates() {
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2}; // The expected answer with correct length

        int k = dfsa.removeDuplicates(nums); // Calls your implementation

        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}