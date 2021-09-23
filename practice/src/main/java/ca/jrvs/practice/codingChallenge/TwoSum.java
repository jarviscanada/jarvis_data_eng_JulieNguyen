package ca.jrvs.practice.codingChallenge;

import java.util.*;

/**
 * Challenge: Two Sum
 * https://www.notion.so/jarvisdev/Two-Sum-81ee81672ea74e96a20a710253d1b0cc
 */
public class TwoSum {
    /**
     * Time complexity O(n^2) due to the use of a nested for-loop.
     * @param arr
     * @param target
     * @return
     */
    public int[] twoSum(int[]arr, int target){
        int [] result = new int[2];
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length; j++){
                if(i!=j && arr[i]+arr[j]==target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /**
     * Time complexity: O(n). Addition of two linear for-loops, not nested and therefore not O(n^2)
     * @param arr
     * @param target
     * @return
     */
    public int[] twoSumUsingMap(int[]arr, int target){
        int [] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], i);
        }

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(target-arr[i])){
                result[0]=map.get(target-arr[i]);
                result[1]=i;
                return result;
            }
        }
        return result;
    }
}
