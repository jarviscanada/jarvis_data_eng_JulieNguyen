package ca.jrvs.practice.codingChallenge;

/**Challenge: Remove Element
 * https://www.notion.so/jarvisdev/Remove-Element-cc3f3f1d529646d7966d0ee7f4ca0c89
 */

public class RemoveElement {

    //O(n)
    public int removeElement(int[] nums, int val) {
        int count = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val)
                nums[count++] = nums[i];
        }

        return count;
    }

}