package ca.jrvs.practice.codingChallenge;

/**Challenge: Remove Duplicates From Sorted Array
 * https://www.notion.so/jarvisdev/Duplicates-from-Sorted-Array-e244b0e01be84dd9bcbbd9d36addc3cf
 */

public class DuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){

            }
            else{
                nums[count]=nums[i];
                count++;
            }
        }
        return count;
    }
}