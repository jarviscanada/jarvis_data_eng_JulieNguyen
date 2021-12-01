package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortedArrayTest {

    MergeSortedArray msa;

    @Before
    public void setUp(){
        msa = new MergeSortedArray();
    }

    @Test
    public void merge() {
        int[]nums1 = {1,2,3,0,0,0};
        int[]nums2 = {2,5,6};
        int m = 3;
        int n = 3;

        int[]expected = {1,2,2,3,5,6};

        msa.merge(nums1, m, nums2, n);

        for (int i = 0; i < (m+n); i++) {
            assert nums1[i] == expected[i];
        }
    }
}