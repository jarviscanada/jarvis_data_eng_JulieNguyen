package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**Challenge: Duplicate Number
 * https://www.notion.so/jarvisdev/Find-the-Duplicate-Number-79a5491564ec4f749397f45681fc9c44
 */

public class DuplicateNumber {

    //O(n) solution
    public int findDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num : nums) {
            if (!numSet.contains(num))
                numSet.add(num);
            else
                return num;
        }
        return 0;
    }

    //O(n log n) Sorting Solution
    public int findDuplicatesUsingSorting(int[]nums){
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1])
                return nums[i];
        }
        return 0;
    }
}