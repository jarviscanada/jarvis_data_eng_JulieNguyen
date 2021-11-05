package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**Challenge: Contains Duplicate
 * https://www.notion.so/jarvisdev/Contains-Duplicate-ff1e7af254a64f0fbd9e2a5135fa6a0d
 */

public class ContainsDuplicate {

    //O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int num: nums){
            if(!numSet.contains(num))
                numSet.add(num);
            else
                return true;
        }
        return false;
    }

}