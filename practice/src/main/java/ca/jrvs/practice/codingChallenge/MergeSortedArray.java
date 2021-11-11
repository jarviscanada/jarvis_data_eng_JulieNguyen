package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;

/**Challenge: Merge Sorted Array
 * https://www.notion.so/jarvisdev/Merge-Sorted-Array-342b25e1ced84f83913c33df96290bb2
 */

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = nums1.length-1;
        for(int i=0; i<nums2.length; i++){
            nums1[count-i]=nums2[i];
        }
        Arrays.sort(nums1);
    }
}